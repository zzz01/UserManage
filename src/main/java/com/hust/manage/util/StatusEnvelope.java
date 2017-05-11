package com.hust.manage.util;

import javax.servlet.http.HttpServletResponse;

public class StatusEnvelope<M, D> {

	private M meg;

	private D data;

	private Long time;

	private Integer status;

	public M getMeg() {
		return meg;
	}

	public void setMeg(M meg) {
		this.meg = meg;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public StatusEnvelope() {
		this.time = System.currentTimeMillis();
	}

	public StatusEnvelope(int status, M msg, D data) {
		this.status = status;
		this.data = data;
		this.meg = msg;
		this.time = System.currentTimeMillis();
	}

	public static <M, D> StatusEnvelope<M, D> ok(M msg, D data) {
		return new StatusEnvelope<M, D>(HttpServletResponse.SC_OK, msg, data);
	}

	public static <M> StatusEnvelope<M, Object> message(Integer status, M msg) {
		return new StatusEnvelope<M, Object>(status, msg, null);
	}

	public static <D> StatusEnvelope<Object, D> data(D data) {
		return ok(null, data);
	}

	public static <M> StatusEnvelope<M, Object> unauthorized(M message) {
		return message(HttpServletResponse.SC_UNAUTHORIZED, message);
	}

	public static <M> StatusEnvelope<M, Object> forbidden(M message) {
		return message(HttpServletResponse.SC_FORBIDDEN, message);
	}

	public static <M> StatusEnvelope<M, Object> badRequest(M message) {
		return message(HttpServletResponse.SC_BAD_REQUEST, message);
	}

	public static <M> StatusEnvelope<M, Object> notFound(M message) {
		return message(HttpServletResponse.SC_NOT_FOUND, message);
	}

	public static <M> StatusEnvelope<M, Object> conflict(M message) {
		return message(HttpServletResponse.SC_CONFLICT, message);
	}

	public static <M> StatusEnvelope<M, Object> serverError(M message) {
		return message(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
	}

}
