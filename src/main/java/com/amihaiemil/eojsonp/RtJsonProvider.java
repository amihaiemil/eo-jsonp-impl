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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.spi.JsonProvider;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;

/**
 * Base JsonProvider implementation. Rt stands for "runtime".
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 * @todo #6:30min Continue implementing and unit testing the other methods of
 *  RtJsonProvider. Also start implementing dependent classes such as
 *  RtJsonObjectBuilder.
 */
final class RtJsonProvider extends JsonProvider {

    @Override
    public JsonParser createParser(final Reader reader) {
        return new RtJsonParser(reader);
    }

    @Override
    public JsonParser createParser(final InputStream input) {
        return new RtJsonParser(input);
    }

    @Override
    public JsonObjectBuilder createObjectBuilder() {
        return new RtJsonObjectBuilder();
    }

    @Override
    public JsonArrayBuilder createArrayBuilder() {
        return new RtJsonArrayBuilder();
    }

    @Override
    public JsonParserFactory createParserFactory(final Map<String, ?> config) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator createGenerator(final Writer writer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGenerator createGenerator(final OutputStream out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonGeneratorFactory createGeneratorFactory(
        final Map<String, ?> config
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonReader createReader(final Reader reader) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonReader createReader(final InputStream input) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonWriter createWriter(final Writer writer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonWriter createWriter(final OutputStream out) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonWriterFactory createWriterFactory(
        final Map<String, ?> config
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonReaderFactory createReaderFactory(
        final Map<String, ?> config
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonBuilderFactory createBuilderFactory(
        final Map<String, ?> config
    ) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
