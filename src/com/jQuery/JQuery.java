package com.jQuery;

import java.util.Arrays;

import com.google.gson.JsonObject;
import com.jQuery.functions.Each;
import com.jQuery.properties.Position;

import greencode.jscript.DOM;
import greencode.jscript.DOMHandle;
import greencode.jscript.Element;
import greencode.jscript.ElementHandle;
import greencode.jscript.FunctionHandle;
import greencode.jscript.Node;
import greencode.jscript.Window;
import greencode.kernel.GreenContext;
import greencode.util.StringUtils;

public class JQuery extends DOM {
	public JQuery(String selector) {
		this(selector, GreenContext.getInstance().currentWindow());
	}

	public JQuery(Node e) {
		this(e, GreenContext.getInstance().currentWindow());
	}

	public JQuery(JQuery j) {
		this(j, GreenContext.getInstance().currentWindow());
	}

	public JQuery(String selector, Window window) {
		super(window);

		if(!selector.isEmpty())
			DOMHandle.registerReturnByCommand(window, DOMHandle.getUID(this), "jQuery", selector);
	}

	public JQuery(Node e, Window window) {
		super(window);
		DOMHandle.registerReturnByCommand(window, DOMHandle.getUID(this), "jQuery", e);
	}

	public JQuery(JQuery j, Window window) {
		super(window);

		greencode.jscript.$DOMHandle.setUID(this, DOMHandle.getUID(j));
		greencode.jscript.$DOMHandle.setVariables(this, greencode.jscript.$DOMHandle.getVariables(j));
	}

	private JQuery(Window window) {
		super(window);
	}

	protected final JQuery getInstance(Window window) {
		return new JQuery(window);
	}

	public Integer length() {
		return DOMHandle.getVariableValueByProperty(this, "jquery.length", Integer.class, "length");
	}

	public final String css(String name) {
		return DOMHandle.getVariableValueByCommand(this, "jquery.css." + name, String.class, "css", name);
	}

	public final JQuery css(String name, String value) {
		DOMHandle.setVariableValue(this, "jquery.css." + name, value);
		DOMHandle.execCommand(this, "css", name, value);
		return this;
	}

	public final String attr(String name) {
		return DOMHandle.getVariableValueByCommand(this, "jquery.attr." + name, String.class, "attr", name);
	}

	public final JQuery attr(String name, String value) {
		DOMHandle.setVariableValue(this, "jquery.attr." + name, value);
		DOMHandle.execCommand(this, "attr", name, value);
		return this;
	}

	public final <C> C prop(String name, Class<C> cast) {
		return DOMHandle.getVariableValueByCommand(this, "jquery.prop." + name, cast, "prop", name);
	}

	public final JQuery prop(String name, String value) {
		return __prop(name, value);
	}

	public final JQuery prop(String name, Boolean value) {
		return __prop(name, value);
	}

	private final JQuery __prop(String name, Object value) {
		DOMHandle.setVariableValue(this, "jquery.prop." + name, value);
		DOMHandle.execCommand(this, "prop", name, value);
		return this;
	}

	public final JQuery removeAttr(String name) {
		DOMHandle.removeVariable(this, "jquery.attr." + name);
		DOMHandle.execCommand(this, "removeAttr", name);
		return this;
	}

	public final JQuery removeProp(String name) {
		DOMHandle.removeVariable(this, "jquery.prop." + name);
		DOMHandle.execCommand(this, "removeProp", name);
		return this;
	}

	public final <C> C data(String name, Class<C> cast) {
		return DOMHandle.getVariableValueByCommand(this, "jquery.data." + name, cast, "data", name);
	}

	public final JQuery data(String name, Object value) {
		DOMHandle.setVariableValue(this, "jquery.data." + name, value);
		DOMHandle.execCommand(this, "data", name, value);
		return this;
	}

	public final JQuery removeData(String name) {
		DOMHandle.removeVariable(this, "jquery.data." + name);
		DOMHandle.execCommand(this, "removeData", name);
		return this;
	}

	public JQuery remove() {
		DOMHandle.execCommand(this, "remove");
		return this;
	}

	public JQuery remove(String selector) {
		DOMHandle.execCommand(this, "remove", selector);
		return this;
	}

	public JQuery detach() {
		DOMHandle.execCommand(this, "detach");
		return this;
	}

	public JQuery detach(String selector) {
		DOMHandle.execCommand(this, "detach", selector);
		return this;
	}

	public Boolean hasClass(String className) {
		return DOMHandle.getVariableValueByCommand(this, "jquery.hasClass." + className, Boolean.class, "hasClass", className);
	}

	public Integer height() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.height", Integer.class, "height");
	}

	public JQuery height(String value) {
		DOMHandle.execCommand(this, "height", value);
		return this;
	}

	public Integer width() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.width", Integer.class, "width");
	}

	public JQuery width(String value) {
		DOMHandle.execCommand(this, "width", value);
		return this;
	}

	public Integer scrollLeft() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.scrollLeft", Integer.class, "scrollLeft");
	}

	public JQuery scrollLeft(String value) {
		DOMHandle.execCommand(this, "scrollLeft", value);
		return this;
	}

	public Integer scrollTop() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.scrollTop", Integer.class, "scrollTop");
	}

	public JQuery scrollTop(String value) {
		DOMHandle.execCommand(this, "scrollTop", value);
		return this;
	}

	public Integer innerHeight() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.innerHeight", Integer.class, "innerHeight");
	}

	public Integer innerWidth() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.innerWidth", Integer.class, "innerWidth");
	}

	public JQuery toggleClass(String className) {
		DOMHandle.execCommand(this, "toggleClass", className);
		return this;
	}

	public JQuery toggleClass(String className, boolean Switch) {
		DOMHandle.execCommand(this, "toggleClass", className, Switch);
		return this;
	}

	public JQuery unwrap() {
		DOMHandle.execCommand(this, "unwrap");
		return this;
	}

	public JQuery wrap(JQuery jQuery) {
		return __wrap(jQuery);
	}

	public JQuery wrap(String selectorOrHtml) {
		return __wrap(selectorOrHtml);
	}

	public JQuery wrap(Node node) {
		return __wrap(node);
	}

	private JQuery __wrap(Object wrappingElement) {
		DOMHandle.execCommand(this, "wrap", wrappingElement);
		return this;
	}

	public JQuery wrapAll(JQuery jQuery) {
		return __wrapAll(jQuery);
	}

	public JQuery wrapAll(String selectorOrHtml) {
		return __wrapAll(selectorOrHtml);
	}

	public JQuery wrapAll(Node node) {
		return __wrapAll(node);
	}

	private JQuery __wrapAll(Object wrappingElement) {
		DOMHandle.execCommand(this, "wrapAll", wrappingElement);
		return this;
	}

	public JQuery wrapInner(String html) {
		DOMHandle.execCommand(this, "wrapInner", html);
		return this;
	}

	public Position offset() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.offset", Position.class, "offset");
	}

	public Position position() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.position", Position.class, "position");
	}

	public Integer outerHeight() {
		return __outerHeightWidth("outerHeight", false);
	}

	public Integer outerHeight(boolean includeMargin) {
		return __outerHeightWidth("outerHeight", includeMargin);
	}

	public Integer outerWidth() {
		return __outerHeightWidth("outerWidth", false);
	}

	public Integer outerWidth(boolean includeMargin) {
		return __outerHeightWidth("outerWidth", includeMargin);
	}

	private Integer __outerHeightWidth(String command, boolean includeMargin) {
		return DOMHandle.getVariableValueByCommand(this, "jquery." + command + "." + includeMargin, Integer.class, command, includeMargin);
	}

	public JQuery offset(Position coordinates) {
		DOMHandle.setVariableValue(this, "jquery.offset", coordinates);
		DOMHandle.execCommand(this, "offset", coordinates);
		return this;
	}

	public JQuery focus() {
		DOMHandle.execCommand(this, "focus");
		return this;
	}

	public JQuery after(JQuery... jQuery) {
		return __after(jQuery);
	}

	public JQuery after(String... html) {
		return __after(html);
	}

	public JQuery after(Node... node) {
		return __after(node);
	}

	private JQuery __after(Object[] contents) {
		return insertElement("after", contents);
	}

	public JQuery before(JQuery... jQuery) {
		return __before(jQuery);
	}

	public JQuery before(String... html) {
		return __before(html);
	}

	public JQuery before(Node... node) {
		return __before(node);
	}

	private JQuery __before(Object[] contents) {
		return insertElement("before", contents);
	}

	private JQuery insertElement(String command, Object... contents) {
		if(contents.length == 1)
			DOMHandle.execCommand(this, command, contents[0]);
		else
			DOMHandle.execCommand(this, command, contents[0], Arrays.asList(contents).remove(0));
		return this;
	}

	public JQuery append(JQuery... jQuery) {
		return __append(jQuery);
	}

	public JQuery append(String... html) {
		return __append(html);
	}

	public JQuery append(Node... node) {
		return __append(node);
	}

	private JQuery __append(Object[] contents) {
		return insertElement("append", contents);
	}

	public JQuery prepend(JQuery... jQuery) {
		return __prepend(jQuery);
	}

	public JQuery prepend(String... html) {
		return __prepend(html);
	}

	public JQuery prepend(Node... node) {
		return __prepend(node);
	}

	private JQuery __prepend(Object[] contents) {
		return insertElement("prepend", contents);
	}

	public JQuery appendTo(JQuery jQuery) {
		return __appendTo(jQuery);
	}

	public JQuery appendTo(String selectorOrHtml) {
		return __appendTo(selectorOrHtml);
	}

	public JQuery appendTo(Node node) {
		return __appendTo(node);
	}

	private JQuery __appendTo(Object target) {
		DOMHandle.execCommand(this, "appendTo", target);
		return this;
	}

	public JQuery prependTo(JQuery jQuery) {
		return __prependTo(jQuery);
	}

	public JQuery prependTo(String selectorOrHtml) {
		return __prependTo(selectorOrHtml);
	}

	public JQuery prependTo(Node node) {
		return __prependTo(node);
	}

	private JQuery __prependTo(Object target) {
		DOMHandle.execCommand(this, "prependTo", target);
		return this;
	}

	public JQuery insertAfter(JQuery jQuery) {
		return __insertAfter(jQuery);
	}

	public JQuery insertAfter(String selector) {
		return __insertAfter(selector);
	}

	public JQuery insertAfter(Node node) {
		return __insertAfter(node);
	}

	private JQuery __insertAfter(Object target) {
		DOMHandle.execCommand(this, "insertAfter", target);
		return this;
	}

	public JQuery insertBefore(JQuery jQuery) {
		return __insertBefore(jQuery);
	}

	public JQuery insertBefore(String selector) {
		return __insertBefore(selector);
	}

	public JQuery insertBefore(Node node) {
		return __insertBefore(node);
	}

	private JQuery __insertBefore(Object target) {
		DOMHandle.execCommand(this, "insertBefore", target);
		return this;
	}

	public JQuery replaceAll(JQuery jQuery) {
		return __replaceAll(jQuery);
	}

	public JQuery replaceAll(String selector) {
		return __replaceAll(selector);
	}

	public JQuery replaceAll(Node node) {
		return __replaceAll(node);
	}

	private JQuery __replaceAll(Object target) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "replaceAll", target);
		return jQuery;
	}

	public JQuery replaceWith(JQuery jQuery) {
		return __replaceWith(jQuery);
	}

	public JQuery replaceWith(String html) {
		return __replaceWith(html);
	}

	public JQuery replaceWith(Node node) {
		return __replaceWith(node);
	}

	private JQuery __replaceWith(Object target) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "replaceWith", target);
		return jQuery;
	}

	public JQuery html(String html) {
		DOMHandle.setVariableValue(this, "jquery.html", html);
		DOMHandle.execCommand(this, "html", html);
		return this;
	}

	public String html() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.html", String.class, "html");
	}

	public JQuery text(String text) {
		DOMHandle.setVariableValue(this, "jquery.text", text);
		DOMHandle.execCommand(this, "text", text);
		return this;
	}

	public String text() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.text", String.class, "text");
	}

	public JQuery val(Object value) {
		DOMHandle.setVariableValue(this, "jquery.val", value);
		DOMHandle.execCommand(this, "val", value);
		return this;
	}

	public String val() {
		return DOMHandle.getVariableValueByCommand(this, "jquery.val", String.class, "val");
	}

	public <C> C val(Class<C> cast) {
		return DOMHandle.getVariableValueByCommand(this, "jquery.val", cast, "val");
	}

	public JQuery empty() {
		DOMHandle.execCommand(this, "empty");
		return this;
	}

	public JQuery hide() {
		DOMHandle.execCommand(this, "hide");
		return this;
	}

	public JQuery hide(Number duration) {
		DOMHandle.execCommand(this, "hide", duration);
		return this;
	}

	public JQuery hide(Number duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "hide", duration, complete);
		return this;
	}

	public JQuery hide(Number duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "hide", duration, easing, complete);
		return this;
	}

	public JQuery hide(JsonObject options) {
		DOMHandle.execCommand(this, "hide", options);
		return this;
	}

	public JQuery show() {
		DOMHandle.execCommand(this, "show");
		return this;
	}

	public JQuery show(Number duration) {
		DOMHandle.execCommand(this, "show", duration);
		return this;
	}

	public JQuery show(Number duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "show", duration, complete);
		return this;
	}

	public JQuery show(Number duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "show", duration, easing, complete);
		return this;
	}

	public JQuery show(JsonObject options) {
		DOMHandle.execCommand(this, "show", options);
		return this;
	}

	public JQuery fadeTo(int duration, float opacity) {
		DOMHandle.execCommand(this, "fadeTo", duration, opacity);
		return this;
	}

	public JQuery fadeTo(int duration, float opacity, FunctionHandle complete) {
		DOMHandle.execCommand(this, "fadeTo", duration, opacity, complete);
		return this;
	}

	public JQuery fadeTo(int duration, float opacity, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "fadeTo", duration, opacity, easing, complete);
		return this;
	}

	public JQuery fadeOut() {
		DOMHandle.execCommand(this, "fadeOut");
		return this;
	}

	public JQuery fadeOut(int duration) {
		DOMHandle.execCommand(this, "fadeOut", duration);
		return this;
	}

	public JQuery fadeOut(int duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "fadeOut", duration, complete);
		return this;
	}

	public JQuery fadeOut(int duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "fadeOut", duration, easing, complete);
		return this;
	}

	public JQuery fadeOut(JsonObject options) {
		DOMHandle.execCommand(this, "fadeOut", options);
		return this;
	}

	public JQuery fadeIn() {
		DOMHandle.execCommand(this, "fadeIn");
		return this;
	}

	public JQuery fadeIn(int duration) {
		DOMHandle.execCommand(this, "fadeIn", duration);
		return this;
	}

	public JQuery fadeIn(int duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "fadeIn", duration, complete);
		return this;
	}

	public JQuery fadeIn(int duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "fadeIn", duration, easing, complete);
		return this;
	}

	public JQuery fadeIn(JsonObject options) {
		DOMHandle.execCommand(this, "fadeIn", options);
		return this;
	}

	public JQuery slideDown() {
		DOMHandle.execCommand(this, "slideDown");
		return this;
	}

	public JQuery slideDown(int duration) {
		DOMHandle.execCommand(this, "slideDown", duration);
		return this;
	}

	public JQuery slideDown(int duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "slideDown", duration, complete);
		return this;
	}

	public JQuery slideDown(int duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "slideDown", duration, easing, complete);
		return this;
	}

	public JQuery slideDown(JsonObject options) {
		DOMHandle.execCommand(this, "slideDown", options);
		return this;
	}

	public JQuery slideToggle() {
		DOMHandle.execCommand(this, "slideToggle");
		return this;
	}

	public JQuery slideToggle(int duration) {
		DOMHandle.execCommand(this, "slideToggle", duration);
		return this;
	}

	public JQuery slideToggle(int duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "slideToggle", duration, complete);
		return this;
	}

	public JQuery slideToggle(int duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "slideToggle", duration, easing, complete);
		return this;
	}

	public JQuery slideToggle(JsonObject options) {
		DOMHandle.execCommand(this, "slideToggle", options);
		return this;
	}

	public JQuery slideUp() {
		DOMHandle.execCommand(this, "slideUp");
		return this;
	}

	public JQuery slideUp(int duration) {
		DOMHandle.execCommand(this, "slideUp", duration);
		return this;
	}

	public JQuery slideUp(int duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "slideUp", duration, complete);
		return this;
	}

	public JQuery slideUp(int duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "slideUp", duration, easing, complete);
		return this;
	}

	public JQuery slideUp(JsonObject options) {
		DOMHandle.execCommand(this, "slideUp", options);
		return this;
	}

	public JQuery toggle() {
		DOMHandle.execCommand(this, "toggle");
		return this;
	}

	public JQuery toggle(int duration) {
		DOMHandle.execCommand(this, "toggle", duration);
		return this;
	}

	public JQuery toggle(int duration, FunctionHandle complete) {
		DOMHandle.execCommand(this, "toggle", duration, complete);
		return this;
	}

	public JQuery toggle(int duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "toggle", duration, easing, complete);
		return this;
	}

	public JQuery toggle(JsonObject options) {
		DOMHandle.execCommand(this, "toggle", options);
		return this;
	}

	public JQuery toggle(boolean showOrHide) {
		DOMHandle.execCommand(this, "toggle", showOrHide);
		return this;
	}

	public JQuery stop() {
		DOMHandle.execCommand(this, "stop");
		return this;
	}

	public JQuery stop(boolean clearQueue) {
		DOMHandle.execCommand(this, "stop", clearQueue);
		return this;
	}

	public JQuery stop(boolean clearQueue, boolean jumpToEnd) {
		DOMHandle.execCommand(this, "stop", clearQueue, jumpToEnd);
		return this;
	}

	public JQuery stop(String queue, boolean clearQueue, boolean jumpToEnd) {
		DOMHandle.execCommand(this, "stop", queue, clearQueue, jumpToEnd);
		return this;
	}

	public JQuery filter(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "filter", selector);
		return jQuery;
	}

	public JQuery find(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "find", selector);
		return jQuery;
	}

	public JQuery end() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "end");
		return jQuery;
	}

	public JQuery addClass(String Class) {
		DOMHandle.execCommand(this, "addClass", Class);
		return this;
	}

	public JQuery removeClass(String Class) {
		DOMHandle.execCommand(this, "removeClass", Class);
		return this;
	}

	public JQuery on(String eventName, FunctionHandle handle) {
		DOMHandle.execCommand(this, "on", eventName, handle);
		return this;
	}

	public JQuery on(String[] eventsName, FunctionHandle handle) {
		DOMHandle.execCommand(this, "on", StringUtils.join(eventsName, ','), handle);
		return this;
	}

	public JQuery off(String eventName) {
		DOMHandle.execCommand(this, "off", eventName);
		return this;
	}

	public JQuery off(String[] eventsName) {
		DOMHandle.execCommand(this, "off", StringUtils.join(eventsName, ','));
		return this;
	}

	public JQuery trigger(String eventName) {
		DOMHandle.execCommand(this, "trigger", eventName);
		return this;
	}

	public JQuery trigger(String[] eventsName) {
		DOMHandle.execCommand(this, "trigger", StringUtils.join(eventsName, ','));
		return this;
	}

	public JQuery parent() {
		return __parent("parent", null);
	}

	public JQuery parent(String selector) {
		return __parent("parent", selector);
	}

	public JQuery parents() {
		return __parent("parents", null);
	}

	public JQuery parents(String selector) {
		return __parent("parents", selector);
	}

	private JQuery __parent(String command, String selector) {
		JQuery jQuery = new JQuery(window);
		if(selector == null)
			DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), command);
		else
			DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), command, selector);
		return jQuery;
	}

	public JQuery closest(String selector) {
		return __closest(selector);
	}

	public JQuery closest(JQuery jQuery) {
		return __closest(jQuery);
	}

	public JQuery closest(Element e) {
		return __closest(e);
	}

	private JQuery __closest(Object o) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "closest", o);
		return jQuery;
	}

	public JQuery add(String selectorOrHtml) {
		return __add(selectorOrHtml);
	}

	public JQuery add(Element e) {
		return __add(e);
	}

	public JQuery add(JQuery jQuery) {
		return __add(jQuery);
	}

	private JQuery __add(Object value) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "add", value);
		return jQuery;
	}

	public JQuery addBack() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "addBack");
		return jQuery;
	}

	public JQuery addBack(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "addBack", selector);
		return jQuery;
	}

	public JQuery andSelf() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "andSelf");
		return jQuery;
	}

	public JQuery children() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "children");
		return jQuery;
	}

	public JQuery children(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "children", selector);
		return jQuery;
	}

	public JQuery contents() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "contents");
		return jQuery;
	}

	public JQuery eq(int index) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "eq", index);
		return jQuery;
	}

	public JQuery first() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "first");
		return jQuery;
	}

	public JQuery last() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "last");
		return jQuery;
	}

	public JQuery next() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "next");
		return jQuery;
	}

	public JQuery next(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "next", selector);
		return jQuery;
	}

	public JQuery nextAll() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "nextAll");
		return jQuery;
	}

	public JQuery nextAll(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "nextAll", selector);
		return jQuery;
	}

	public JQuery nextUntil(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "nextUntil", selector);
		return jQuery;
	}

	public JQuery nextUntil(String selector, String filter) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "nextUntil", selector, filter);
		return jQuery;
	}

	public JQuery has(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "has", selector);
		return jQuery;
	}

	public JQuery clone() {
		return __clone();
	}

	public JQuery clone(boolean withDataAndEvents) {
		return __clone(withDataAndEvents);
	}

	public JQuery clone(boolean withDataAndEvents, boolean deepWithDataAndEvents) {
		return __clone(withDataAndEvents, deepWithDataAndEvents);
	}

	private JQuery __clone(boolean... args) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "clone", args);
		return jQuery;
	}

	public JQuery animate(JsonObject properties) {
		DOMHandle.execCommand(this, "animate", properties);
		return this;
	}

	public JQuery animate(JsonObject properties, Number duration) {
		DOMHandle.execCommand(this, "animate", properties, duration);
		return this;
	}

	public JQuery animate(JsonObject properties, Number duration, String easing) {
		DOMHandle.execCommand(this, "animate", properties, duration, easing);
		return this;
	}

	public JQuery animate(JsonObject properties, Number duration, String easing, FunctionHandle complete) {
		DOMHandle.execCommand(this, "animate", properties, duration, easing, complete);
		return this;
	}

	public JQuery animate(JsonObject properties, JsonObject options) {
		DOMHandle.execCommand(this, "animate", properties, options);
		return this;
	}

	public JQuery each(Each function) {
		int length = this.length();
		for(int i = -1; ++i < length;) {
			function.init(i, get(i));
		}

		return this;
	}

	public Element[] toArray() {
		int length = this.length();
		Element[] list = new Element[length];

		for(int i = -1; ++i < length;) {
			list[i] = get(i);
		}

		return list;
	}

	public Element[] get() {
		return toArray();
	}

	public Element get(int index) {
		return get(index, Element.class);
	}

	public <T extends Element> T get(int index, Class<T> clazz) {
		T e = DOMHandle.getVariableValue(this, "get." + index, clazz);
		if(e == null) {
			e = ElementHandle.cast(greencode.jscript.$DOMHandle.getElementInstance(this.window), clazz);
			DOMHandle.setVariableValue(this, "get." + index, e);
			DOMHandle.registerElementByVector(this, e, index);
		}

		return e;
	}

	public Integer index(JQuery jQuery) {
		return __index(jQuery);
	}

	public Integer index(String selector) {
		return __index(selector);
	}

	public Integer index(Element e) {
		return __index(e);
	}

	private Integer __index(Object o) {
		if(o == null)
			return DOMHandle.getVariableValueByCommand(this, "jquery.index", Integer.class, "index");
		else
			return DOMHandle.getVariableValueByCommand(this, "jquery.index", Integer.class, "index", o);
	}

	public Boolean is(JQuery jQuery) {
		return __is(jQuery);
	}

	public Boolean is(String selector) {
		return __is(selector);
	}

	public Boolean is(Element e) {
		return __is(e);
	}

	private Boolean __is(Object o) {
		Boolean res;
		if(o == null)
			res = DOMHandle.getVariableValueByCommand(this, "jquery.is", Boolean.class, "is");
		else
			res = DOMHandle.getVariableValueByCommand(this, "jquery.is", Boolean.class, "is", o);

		DOMHandle.removeVariable(this, "jquery.is");

		return res;
	}

	public JQuery not(JQuery jQuery) {
		return __not(jQuery);
	}

	public JQuery not(String selector) {
		return __not(selector);
	}

	public JQuery not(Element e) {
		return __not(e);
	}

	private JQuery __not(Object o) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "not", o);
		return jQuery;
	}

	public JQuery offsetParent() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "offsetParent");
		return jQuery;
	}

	public JQuery prev() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "prev");
		return jQuery;
	}

	public JQuery prev(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "prev", selector);
		return jQuery;
	}

	public JQuery prevAll() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "prevAll");
		return jQuery;
	}

	public JQuery prevAll(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "prevAll", selector);
		return jQuery;
	}

	public JQuery prevUntil(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "prevUntil", selector);
		return jQuery;
	}

	public JQuery prevUntil(String selector, String filter) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "prevUntil", selector, filter);
		return jQuery;
	}

	public JQuery siblings() {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "siblings");
		return jQuery;
	}

	public JQuery siblings(String selector) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "siblings", selector);
		return jQuery;
	}

	public JQuery slice(int start) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "slice", start);
		return jQuery;
	}

	public JQuery slice(int start, int end) {
		JQuery jQuery = new JQuery(window);
		DOMHandle.registerReturnByCommand(this, DOMHandle.getUID(jQuery), "slice", start, end);
		return jQuery;
	}

	/**
	 * No oficial Method
	 */
	public JQuery executePlugin(String methodName, Object... args) {
		DOMHandle.execCommand(this, methodName, args);
		return this;
	}
}
