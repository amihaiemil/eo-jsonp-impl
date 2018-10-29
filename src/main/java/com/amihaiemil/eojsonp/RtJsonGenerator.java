/**
 * Copyright (c) 2018, Mihai Emil Andronache
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1)Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2)Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 3)Neither the name of eo-jsonp-impl nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.amihaiemil.eojsonp;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

/**
 * Base JsonGenerator implementation. Rt stands for "runtime".
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
final class RtJsonGenerator extends ConvenientJsonGenerator {

    /**
     * Write it somewhere.
     */
    private final Writer writer;
    
    /**
     * Ctor.
     * @param output Stream to write to.
     */
    RtJsonGenerator(final OutputStream output) {
        this(new OutputStreamWriter(output));
    }
    
    /**
     * Ctor.
     * @param writer Writer to use.
     */
    RtJsonGenerator(final Writer writer) {
        this.writer = writer;
    }
    
    @Override
    public JsonGenerator writeStartObject() {
        return new StartObject();
    }

    @Override
    public JsonGenerator writeStartObject(final String name) {
        throw new IllegalStateException(
            "Cannot write named JsonArray, base Json structure is not "
          + "started yet. Use #writeStartObject() or #writeStartObject()."
        );
    }

    @Override
    public JsonGenerator writeKey(final String name) {
        return new WriteJsonValue();
    }

    @Override
    public JsonGenerator writeStartArray() {
        return new StartArray();
    }

    @Override
    public JsonGenerator writeStartArray(final String name) {
        throw new IllegalStateException(
            "Cannot write named JsonArray, base Json structure is not "
          + "started yet. Use #writeStartObject() or #writeStartObject()."
        );
    }

    @Override
    public JsonGenerator write(final String name, final JsonValue value) {
        throw new IllegalStateException(
            "Cannot write named JsonValue, base Json structure is not "
          + "started yet. Use #writeStartObject() or #writeStartObject()."
        );
    }

    @Override
    public JsonGenerator writeEnd() {
        throw new IllegalStateException(
            "Cannot end the Json structure, base Json structure is not "
          + "started yet. Use #writeStartObject() or #writeStartObject()."
        );
    }

    @Override
    public JsonGenerator write(final JsonValue value) {
        throw new IllegalStateException(
            "Cannot write JsonValue, base Json structure is not "
          + "started yet. Use #writeStartObject() or #writeStartObject()."
        );
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * A JsonGenerator for started JsonObjects.
     */
    private final class StartObject extends ConvenientJsonGenerator {

        @Override
        public JsonGenerator writeStartObject() {
            throw new IllegalStateException("JsonObject is already started!");
        }

        @Override
        public JsonGenerator writeStartObject(final String name) {
            return new StartObject();
        }

        @Override
        public JsonGenerator writeKey(final String name) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public JsonGenerator writeStartArray() {
            throw new IllegalStateException(
                "Within a JsonObject, a JsonArray needs to have a key. "
              + "Write a key first (#writeKey(name)) or start a JsonArray "
              + "with a name (method writeStartArray(name))."
            );
        }

        @Override
        public JsonGenerator writeStartArray(final String name) {
            return new StartArray();
        }

        @Override
        public JsonGenerator write(final String name, final JsonValue value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public JsonGenerator write(final JsonValue value) {
            throw new IllegalStateException(
                "Within a JsonObject, a JsonValue needs to have a key. "
              + "Write a key first (#writeKey(name)), start a JsonObject "
              + "or a JsonArray with a name or write a key/value pair"
            );
        }

        @Override
        public JsonGenerator writeEnd() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void flush() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
    
    /**
     * A JsonGenerator for started JsonArrays.
     */
    private final class StartArray extends ConvenientJsonGenerator {

        @Override
        public JsonGenerator writeStartObject() {
            return new StartObject();
        }

        @Override
        public JsonGenerator writeStartObject(final String name) {
            throw new IllegalStateException(
                "Within a JsonArray there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator writeKey(final String name) {
            throw new IllegalStateException(
                "Within a JsonArray there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator writeStartArray() {
            return new StartArray();
        }

        @Override
        public JsonGenerator writeStartArray(final String name) {
            throw new IllegalStateException(
                "Within a JsonArray there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator write(final String name, final JsonValue value) {
            throw new IllegalStateException(
                "Within a JsonArray there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator write(final JsonValue value) {
            throw new IllegalStateException("Not supported yet.");
        }

        @Override
        public JsonGenerator writeEnd() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void flush() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
    
    /**
     * A JsonGenerator which mandates the writing of a JsonValue after a key
     * is previously added.
     */
    private final class WriteJsonValue extends ConvenientJsonGenerator {

        @Override
        public JsonGenerator writeStartObject() {
            return new StartObject();
        }

        @Override
        public JsonGenerator writeStartObject(final String name) {
            throw new IllegalStateException(
                "After a Json key, there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator writeKey(final String name) {
            throw new IllegalStateException(
                "Cannot write another key, need a JsonValue."
            );
        }

        @Override
        public JsonGenerator writeStartArray() {
            return new StartArray();
        }

        @Override
        public JsonGenerator writeStartArray(final String name) {
            throw new IllegalStateException(
                "After a Json key, there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator write(final String name, final JsonValue value) {
            throw new IllegalStateException(
                "After a Json key, there cannot be named Json strucutres, "
              + "only unnamed JsonArray, JsonObjects or other JsonValues"
            );
        }

        @Override
        public JsonGenerator write(final JsonValue value) {
            throw new IllegalStateException("Not supported yet.");
        }

        @Override
        public JsonGenerator writeEnd() {
            throw new IllegalStateException(
                "Cannot and the Json structure here. Need a JsonValue!"
            );
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void flush() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
    
}
