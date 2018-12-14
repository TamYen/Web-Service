package com.trungndz.classroombook.entities;
// Generated 12-Dec-2018 00:21:12 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RoomsessionId generated by hbm2java
 */
@Embeddable
public class RoomsessionId implements java.io.Serializable {

	private int idroom;
	private int idsession;

	public RoomsessionId() {
	}

	public RoomsessionId(int idroom, int idsession) {
		this.idroom = idroom;
		this.idsession = idsession;
	}

	@Column(name = "idroom", nullable = false)
	public int getIdroom() {
		return this.idroom;
	}

	public void setIdroom(int idroom) {
		this.idroom = idroom;
	}

	@Column(name = "idsession", nullable = false)
	public int getIdsession() {
		return this.idsession;
	}

	public void setIdsession(int idsession) {
		this.idsession = idsession;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoomsessionId))
			return false;
		RoomsessionId castOther = (RoomsessionId) other;

		return (this.getIdroom() == castOther.getIdroom()) && (this.getIdsession() == castOther.getIdsession());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdroom();
		result = 37 * result + this.getIdsession();
		return result;
	}

}