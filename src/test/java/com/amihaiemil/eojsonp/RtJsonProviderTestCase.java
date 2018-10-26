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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.spi.JsonProvider;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Unit tests for {@link RtJsonProvider}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RtJsonProviderTestCase {
    
    /**
     * RtJsonProvider can create a JsonParser from a Reader.
     */
    @Test
    public void createsParserFromReader() {
        final JsonProvider prov = new RtJsonProvider();
        MatcherAssert.assertThat(
            prov.createParser(new StringReader("test")),
            Matchers.allOf(
                Matchers.instanceOf(JsonParser.class),
                Matchers.notNullValue()
            )
        );
    }
    
    /**
     * RtJsonProvider can create a JsonParser from an InputStream.
     */
    @Test
    public void createsParserFromInputStream() {
        final JsonProvider prov = new RtJsonProvider();
        MatcherAssert.assertThat(
            prov.createParser(
                new ByteArrayInputStream("test".getBytes())
            ),
            Matchers.allOf(
                Matchers.instanceOf(JsonParser.class),
                Matchers.notNullValue()
            )
        );
    }
    
    /**
     * RtJsonProvider can create a JsonObjectBuilder.
     */
    @Test
    public void createsObjectBuilder() {
        final JsonProvider prov = new RtJsonProvider();
        MatcherAssert.assertThat(
            prov.createObjectBuilder(),
            Matchers.allOf(
                Matchers.instanceOf(JsonObjectBuilder.class),
                Matchers.notNullValue()
            )
        );
    }
    
    /**
     * RtJsonProvider can create a JsonObjectBuilder.
     */
    @Test
    public void createsArrayBuilder() {
        final JsonProvider prov = new RtJsonProvider();
        MatcherAssert.assertThat(
            prov.createArrayBuilder(),
            Matchers.allOf(
                Matchers.instanceOf(JsonArrayBuilder.class),
                Matchers.notNullValue()
            )
        );
    }
    
    /**
     * RtJsonProvider can create a JsonGenerator from a Writer.
     */
    @Test
    public void createsGeneratorFromWriter() {
        final JsonProvider prov = new RtJsonProvider();
        MatcherAssert.assertThat(
            prov.createGenerator(new StringWriter()),
            Matchers.allOf(
                Matchers.instanceOf(JsonGenerator.class),
                Matchers.notNullValue()
            )
        );
    }
    
    /**
     * RtJsonProvider can create a JsonGenerator from an OutputStream.
     */
    @Test
    public void createsGeneratorFromOutputStream() {
        final JsonProvider prov = new RtJsonProvider();
        MatcherAssert.assertThat(
            prov.createGenerator(new ByteArrayOutputStream()),
            Matchers.allOf(
                Matchers.instanceOf(JsonGenerator.class),
                Matchers.notNullValue()
            )
        );
    }
    
}
