package com.sisyphusWeb.webService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sisyphusWeb.webService.model.table.BallPosition;
import com.sisyphusWeb.webService.model.table.Coordinate;
import com.sisyphusWeb.webService.model.table.QueueItem;
import com.sisyphusWeb.webService.model.table.StreamItem;
import com.sisyphusWeb.webService.model.table.Track;
import com.sisyphusWeb.webService.repository.QueueRepository;
import com.sisyphusWeb.webService.repository.StreamRepository;
import com.sisyphusWeb.webService.repository.TrackRepository;

@Service
public class QueueService {

	@Autowired
	private QueueRepository queueRepo;
	
	@Autowired
	private TrackRepository trackRepo;
	
	@Autowired
	private StreamRepository streamRepo;
	
	@Autowired
	private TableService tableService;
	
	@Autowired
	private TrackService trackService;
	
	private boolean isStreaming = true;
	
	private double lastRho = 0;
	
	private double lastTheta = 0;
	
	String activeTrack;
	
	public List<QueueItem> returnQueue() {
		return queueRepo.findAll();
	}

	public String addToQueue(String trackId) {
		if(queueRepo.existsByTrackId(trackId)) return "Track already in queue please choose a different one";
		if(!trackRepo.existsById(trackId)) return "This track does not exist in the database please choose a different one";
		long index = queueRepo.count();
		QueueItem queue = new QueueItem(index+1, trackId, false);
		queueRepo.save(queue);
		return "Saved";
	}
	
	public String addToFrontofQueue(String trackId) {		
		if(queueRepo.existsByTrackId(trackId)) return "Track already in queue please choose a different one";
		List<QueueItem> queue = queueRepo.findAll();
		QueueItem queueItem = new QueueItem(1, trackId, false);
		queueRepo.deleteAll();
		
		for(QueueItem tempQueueItem : queue) {
			tempQueueItem.setId(tempQueueItem.getId()+1);
		}
		
		queue.add(0, queueItem);
		
		queueRepo.saveAll(queue);
		
		return "Saved";
	}
	
	public String removeFromQueue(String trackId) {
		if(!queueRepo.existsByTrackId(trackId)) return "Track is not present in queue";
		
		QueueItem queueItem = queueRepo.findByTrackId(trackId);
		long index = queueItem.getId();
		
		queueRepo.delete(queueItem);
		
		List<QueueItem> queue = queueRepo.findAll();
		queueRepo.deleteAll();
		
		for(QueueItem tempQueueItem : queue) {
			if(tempQueueItem.getId() > index) {
				tempQueueItem.setId(tempQueueItem.getId()-1);
			}
		}
		
		queueRepo.saveAll(queue);
		
		return "Deleted";
	}
	
	public String setClear(String trackId, boolean bool) {
		if(!queueRepo.existsByTrackId(trackId)) return "Track is not present in queue";
		QueueItem queueItem = queueRepo.findByTrackId(trackId);
		queueItem.setSendClear(bool);
		queueRepo.save(queueItem);
		return "Clear set";
	}
	
	public void sendClear(String streamId) {
		List<Coordinate> coords = new ArrayList<>();
		coords.add(new Coordinate(0, 0));
		coords.add(new Coordinate( (float) 314.15, 1));
		for(Coordinate coord : coords) {
			String coordinateString = "{\"th\":" + coord.getTheta() + ",\"r\":" + coord.getRho() + "}";
			tableService.add_verts(streamId, coordinateString);
		}
	}
	
	public void sendTrack(String streamId, String trackId) {
		List<Coordinate> coords = trackService.setTrackCoordinates(trackRepo.findById(trackId).get().getTheta_location());
		String coordinateString = trackService.streamStringBuilder(coords);
		tableService.add_verts(streamId, coordinateString);
	}
	
	public void sendTrackByCoord(String streamId, String trackId) {
		List<Coordinate> coords = trackService.setTrackCoordinates(trackRepo.findById(trackId).get().getTheta_location());
		for(Coordinate coord : coords) {
			String coordinateString = "{\"th\":" + coord.getTheta() + ",\"r\":" + coord.getRho() + "}";
			tableService.add_verts(streamId, coordinateString);
		}
	}
	
	public boolean getClear(String trackId) {
		return queueRepo.findByTrackId(trackId).isSendClear();
	}
	
	public Track returnActiveTrack() {
		return trackRepo.findById(activeTrack).get();
	}
	
	public String returnStreamId() {
		return streamRepo.getOne(1).getStreamId();
	}
	
//	@Scheduled(fixedRate=5000)
//	public void updateQueue() throws InterruptedException {
//		if(!isStreaming) {
//			int remainingTime = tableService.getTrackTime().getRemaining_time();
//			if(remainingTime <= 0) {
//				long count = queueRepo.count();
//				if(count > 0) {
//					QueueItem queueItem = returnQueue().get(0);
//					boolean isClear = queueItem.isSendClear();
//					if(isClear) {
//						queueItem.setSendClear(false);
//						queueRepo.save(queueItem);
//						String erase = trackRepo.findByName("Erase").getId();
//						tableService.set_track(erase);
//					} else {
//						tableService.set_track(queueItem.getTrack());
//						removeFromQueue(queueItem.getTrack());
//					}
//				}
//			}
//		} else {
//			BallPosition ballPos = tableService.get_ball_position();
//			double rho = ballPos.getR();
//			double theta = ballPos.getTh();
//			if(rho == lastRho && theta == lastTheta) {
//				long count = queueRepo.count();
//				if(count > 0) {
//					if(streamRepo.count() <= 0) {
//						String streamId = tableService.start_streaming();
//						streamRepo.save(new StreamItem(1, streamId));
//						Thread.sleep(2000);
//					} else {
//						String streamId = streamRepo.findById(1).get().getStreamId();
//						tableService.stop_streaming(streamId);
//						Thread.sleep(2000);
//						streamId = tableService.start_streaming();
//						streamRepo.save(new StreamItem(1, streamId));
//					}
//					QueueItem queueItem = returnQueue().get(0);
//					boolean isClear = queueItem.isSendClear();
//					if(isClear) {
//						queueItem.setSendClear(false);
//						queueRepo.save(queueItem);
//						String streamId = streamRepo.findById(1).get().getStreamId();
//						sendClear(streamId);
//						Thread.sleep(20000);
//						
//					} else {
//						String streamId = streamRepo.findById(1).get().getStreamId();
////						sendTrack(streamId, queueItem.getTrack());
//						sendTrackByCoord(streamId, queueItem.getTrack());
//						Thread.sleep(2000);
//						activeTrack = queueItem.getTrack();
//						removeFromQueue(queueItem.getTrack());
//					}
//				} else {
//					activeTrack = "";
//				}
//			}
//			lastRho = ballPos.getR();
//			lastTheta = ballPos.getTh();
//		}
//	}
}
