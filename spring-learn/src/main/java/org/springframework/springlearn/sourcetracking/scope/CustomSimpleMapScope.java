package org.springframework.springlearn.sourcetracking.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.io.Serializable;
import java.util.*;

/**
 * @author Juergen Hoeller
 */
@SuppressWarnings("serial")
public class CustomSimpleMapScope implements Scope, Serializable {

	private final Map<String, Object> map = new HashMap<>();

	private final List<Runnable> callbacks = new LinkedList<>();


	public CustomSimpleMapScope() {
	}

	public final Map<String, Object> getMap() {
		return this.map;
	}


	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		synchronized (this.map) {
			Object scopedObject = this.map.get(name);
			if (scopedObject == null) {
				scopedObject = objectFactory.getObject();
				this.map.put(name, scopedObject);
			}
			return scopedObject;
		}
	}

	@Override
	public Object remove(String name) {
		synchronized (this.map) {
			return this.map.remove(name);
		}
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		this.callbacks.add(callback);
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	public void close() {
		for (Iterator<Runnable> it = this.callbacks.iterator(); it.hasNext(); ) {
			Runnable runnable = it.next();
			runnable.run();
		}
	}

	@Override
	public String getConversationId() {
		return null;
	}

}
