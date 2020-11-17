package com.sisyphusWeb.webService.model.table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Table {

	@Id
	private String id;
	
	private String type;
	
	private String pi_id;
	
	private String name;
	
	private String firmware_version;
	
	private String software_version;
	
	private String state;
	
	private boolean is_rgbw;
	
	private float brightness;
	
	private boolean is_autodim;
	
	private float speed;
	
	private boolean is_shuffle;
	
	private boolean is_loop;
	
	private boolean is_paused_between_tracks;
	
	private String active_playlist_id;
	
	@OneToOne
	private Track active_track;
	
	private String[] playlist_ids;
	
	private String[] track_ids;
	
	private String[] led_pattern_ids;
	
	public Table() {
		
	}

	public Table(String id, String type, String pi_id, String name, String firmware_version, String software_version,
			String state, boolean is_rgbw, float brightness, boolean is_autodim, float speed, boolean is_shuffle,
			boolean is_loop, boolean is_paused_between_tracks, String active_playlist_id, Track active_track,
			String[] playlist_ids, String[] track_ids, String[] led_pattern_ids) {
		this.id = id;
		this.type = type;
		this.pi_id = pi_id;
		this.name = name;
		this.firmware_version = firmware_version;
		this.software_version = software_version;
		this.state = state;
		this.is_rgbw = is_rgbw;
		this.brightness = brightness;
		this.is_autodim = is_autodim;
		this.speed = speed;
		this.is_shuffle = is_shuffle;
		this.is_loop = is_loop;
		this.is_paused_between_tracks = is_paused_between_tracks;
		this.active_playlist_id = active_playlist_id;
		this.active_track = active_track;
		this.playlist_ids = playlist_ids;
		this.track_ids = track_ids;
		this.led_pattern_ids = led_pattern_ids;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPi_id() {
		return pi_id;
	}

	public void setPi_id(String pi_id) {
		this.pi_id = pi_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirmware_version() {
		return firmware_version;
	}

	public void setFirmware_version(String firmware_version) {
		this.firmware_version = firmware_version;
	}

	public String getSoftware_version() {
		return software_version;
	}

	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isIs_rgbw() {
		return is_rgbw;
	}

	public void setIs_rgbw(boolean is_rgbw) {
		this.is_rgbw = is_rgbw;
	}

	public float getBrightness() {
		return brightness;
	}

	public void setBrightness(float brightness) {
		this.brightness = brightness;
	}

	public boolean isIs_autodim() {
		return is_autodim;
	}

	public void setIs_autodim(boolean is_autodim) {
		this.is_autodim = is_autodim;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public boolean isIs_shuffle() {
		return is_shuffle;
	}

	public void setIs_shuffle(boolean is_shuffle) {
		this.is_shuffle = is_shuffle;
	}

	public boolean isIs_loop() {
		return is_loop;
	}

	public void setIs_loop(boolean is_loop) {
		this.is_loop = is_loop;
	}

	public boolean isIs_paused_between_tracks() {
		return is_paused_between_tracks;
	}

	public void setIs_paused_between_tracks(boolean is_paused_between_tracks) {
		this.is_paused_between_tracks = is_paused_between_tracks;
	}

	public String getActive_playlist_id() {
		return active_playlist_id;
	}

	public void setActive_playlist_id(String active_playlist_id) {
		this.active_playlist_id = active_playlist_id;
	}

	public Track getActive_track() {
		return active_track;
	}

	public void setActive_track(Track active_track) {
		this.active_track = active_track;
	}

	public String[] getPlaylist_ids() {
		return playlist_ids;
	}

	public void setPlaylist_ids(String[] playlist_ids) {
		this.playlist_ids = playlist_ids;
	}

	public String[] getTrack_ids() {
		return track_ids;
	}

	public void setTrack_ids(String[] track_ids) {
		this.track_ids = track_ids;
	}

	public String[] getLed_pattern_ids() {
		return led_pattern_ids;
	}

	public void setLed_pattern_ids(String[] led_pattern_ids) {
		this.led_pattern_ids = led_pattern_ids;
	}
}
