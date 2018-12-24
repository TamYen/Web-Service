package com.trungndz.classroombook.entities;

import java.sql.Date;

public class RoomAvailable {
	int idroom;
	String roomname;
	int session;
	Date date;
	public int getIdroom() {
		return idroom;
	}
	public void setIdroom(int idroom) {
		this.idroom = idroom;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public RoomAvailable(int idroom, String roomname, int session, Date date) {
		super();
		this.idroom = idroom;
		this.roomname = roomname;
		this.session = session;
		this.date = date;
	}
	public RoomAvailable() {}
}
