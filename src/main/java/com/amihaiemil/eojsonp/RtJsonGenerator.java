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
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

/**
 * Base JsonGenerator implementation. Rt stands for "runtime".
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #8:30min Continue implementing and unit testing this class.
 *  Follow an "object-first" approach: that is, we should implement
 *  the situation itself through objects rather than writing
 *  procedural code to deal with the situation. We will have multiple
 *  implementations of JsonGenerator (primarily for Object and array) which
 *  will know when it is possible to add some value and when not.
 */
final class RtJsonGenerator implements JsonGenerator {

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeStartObject(final String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeKey(final String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeStartArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeStartArray(final String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final JsonValue value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final BigInteger value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final BigDecimal value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final long value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final double value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String name, final boolean value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeNull(final String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeEnd() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final JsonValue value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final BigDecimal value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final BigInteger value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final long value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final double value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator write(final boolean value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator writeNull() {
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
