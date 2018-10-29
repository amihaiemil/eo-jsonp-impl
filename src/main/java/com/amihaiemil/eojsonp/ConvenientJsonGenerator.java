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

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

/**
 * Abstract JsonGenerator containing convenience writing methods.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
abstract class ConvenientJsonGenerator implements JsonGenerator {
    
    @Override
    public abstract JsonGenerator writeStartObject();

    @Override
    public abstract JsonGenerator writeStartObject(final String name);

    @Override
    public abstract JsonGenerator writeKey(final String name);

    @Override
    public abstract JsonGenerator writeStartArray();

    @Override
    public abstract JsonGenerator writeStartArray(final String name);

    @Override
    public abstract JsonGenerator write(
        final String name, final JsonValue value
    );
    
    @Override
    public abstract JsonGenerator write(final JsonValue value);
    
    @Override
    public abstract JsonGenerator writeEnd();
    
    @Override
    public JsonGenerator write(final String name, final String value) {
        this.write(name, new RtJsonString(value));
        return this;
    }

    @Override
    public JsonGenerator write(final String name, final BigInteger value) {
        this.write(name, new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final String name, final BigDecimal value) {
        this.write(name, new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final String name, final int value) {
        this.write(name, new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final String name, final long value) {
        this.write(name, new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final String name, final double value) {
        this.write(name, new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final String name, final boolean value) {
        this.write(name, new RtJsonString(value ? "true" : "false"));
        return this;
    }

    @Override
    public JsonGenerator writeNull(final String name) {
        this.write(name, new RtJsonString("null"));
        return this;
    }

    @Override
    public JsonGenerator write(final String value) {
        this.write(new RtJsonString(value));
        return this;
    }

    @Override
    public JsonGenerator write(final BigDecimal value) {
        this.write(new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final BigInteger value) {
        this.write(new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final int value) {
        this.write(new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final long value) {
        this.write(new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final double value) {
        this.write(new RtJsonNumber(String.valueOf(value)));
        return this;
    }

    @Override
    public JsonGenerator write(final boolean value) {
        this.write(new RtJsonString(value ? "true" : "false"));
        return this;
    }

    @Override
    public JsonGenerator writeNull() {
        this.write(new RtJsonString("null"));
        return this;
    }

    @Override
    public abstract void close();

    @Override
    public abstract void flush();
    
}
