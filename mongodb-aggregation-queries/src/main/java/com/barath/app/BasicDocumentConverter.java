package com.barath.app;

import org.bson.Document;

public interface BasicDocumentConverter<T> {
	
	public Document toDocument(T t);
	
	public T toObject(Document document);

}
