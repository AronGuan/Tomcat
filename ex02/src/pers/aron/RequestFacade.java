package pers.aron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class RequestFacade implements ServletRequest {

	private ServletRequest request = null;

	public RequestFacade(Request request) {
		this.request = request;
	}

	@Override
	public Object getAttribute(String attribute) {
		return request.getAttribute(attribute);
	}
	@Override
	public Enumeration getAttributeNames() {
		return request.getAttributeNames();
	}
	@Override
	public String getRealPath(String path) {
		return request.getRealPath(path);
	}
	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return request.getRequestDispatcher(path);
	}
	@Override
	public boolean isSecure() {
		return request.isSecure();
	}
	@Override
	public String getCharacterEncoding() {
		return request.getCharacterEncoding();
	}
	@Override
	public int getContentLength() {
		return request.getContentLength();
	}
	@Override
	public String getContentType() {
		return request.getContentType();
	}
	@Override
	public ServletInputStream getInputStream() throws IOException {
		return request.getInputStream();
	}
	@Override
	public Locale getLocale() {
		return request.getLocale();
	}
	@Override
	public Enumeration getLocales() {
		return request.getLocales();
	}
	@Override
	public String getParameter(String name) {
		return request.getParameter(name);
	}
	@Override
	public Map getParameterMap() {
		return request.getParameterMap();
	}
	@Override
	public Enumeration getParameterNames() {
		return request.getParameterNames();
	}
	@Override
	public String[] getParameterValues(String parameter) {
		return request.getParameterValues(parameter);
	}
	@Override
	public String getProtocol() {
		return request.getProtocol();
	}
	@Override
	public BufferedReader getReader() throws IOException {
		return request.getReader();
	}
	@Override
	public String getRemoteAddr() {
		return request.getRemoteAddr();
	}
	@Override
	public String getRemoteHost() {
		return request.getRemoteHost();
	}
	@Override
	public String getScheme() {
		return request.getScheme();
	}
	@Override
	public String getServerName() {
		return request.getServerName();
	}
	@Override
	public int getServerPort() {
		return request.getServerPort();
	}
	@Override
	public void removeAttribute(String attribute) {
		request.removeAttribute(attribute);
	}
	@Override
	public void setAttribute(String key, Object value) {
		request.setAttribute(key, value);
	}
	@Override
	public void setCharacterEncoding(String encoding)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding(encoding);
	}

	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}
}
