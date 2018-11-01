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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.json.JsonException;
import javax.json.stream.JsonGenerator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests for {@link RtJsonGenerator}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RtJsonGeneratorTestCase {
    
    /**
     * RtJsonGenerator can start writing a JsonObject.
     */
    @Test
    public void startsJsonObject() {
        final Writer written = new StringWriter();
        final JsonGenerator gen = new RtJsonGenerator(written);
        MatcherAssert.assertThat(
            gen.writeStartObject(),
            Matchers.allOf(
                Matchers.notNullValue(),
                Matchers.instanceOf(RtJsonGenerator.ContinueObject.class)
            )
        );
        MatcherAssert.assertThat(written.toString(), Matchers.equalTo("{"));
    }
    
    /**
     * RtJsonGenerator can start writing a JsonArray.
     */
    @Test
    public void startsJsonArray() {
        final Writer written = new StringWriter();
        final JsonGenerator gen = new RtJsonGenerator(written);
        MatcherAssert.assertThat(
            gen.writeStartArray(),
            Matchers.allOf(
                Matchers.notNullValue(),
                Matchers.instanceOf(RtJsonGenerator.ContinueArray.class)
            )
        );
        MatcherAssert.assertThat(written.toString(), Matchers.equalTo("["));
    }
    
    /**
     * RtJsonGenerator should only start generating the base Json parent, 
     * so it shouldn't be able to create named JsonObjects.
     */
    @Test(expected = JsonException.class)
    public void cannotStartNamedObject() {
        new RtJsonGenerator(new StringWriter()).writeStartObject("test");
    }
    
    /**
     * RtJsonGenerator should only start generating the base Json parent, 
     * so it shouldn't be able to create named JsonArrays.
     */
    @Test(expected = JsonException.class)
    public void cannotStartNamedArray() {
        new RtJsonGenerator(new StringWriter()).writeStartArray("test");
    }
    
    /**
     * RtJsonGenerator should only start generating the base Json parent, 
     * so it shouldn't be able to write any key/value pairs.
     */
    @Test(expected = JsonException.class)
    public void cannotWriteKeyValue() {
        new RtJsonGenerator(new StringWriter()).write(
            "key", new RtJsonNumber("1")
        );
    }
    
    /**
     * RtJsonGenerator should only start generating the base Json parent, 
     * so it shouldn't be able to write any JsonValue.
     */
    @Test(expected = JsonException.class)
    public void cannotWriteJsonValue() {
        new RtJsonGenerator(new StringWriter()).write(new RtJsonString("test"));
    }
    
    /**
     * RtJsonGenerator should only start generating the base Json parent, 
     * so it shouldn't be able write the end of the it.
     */
    @Test(expected = JsonException.class)
    public void cannotWriteJsonEnd() {
        new RtJsonGenerator(new StringWriter()).writeEnd();
    }
    
    /**
     * RtJsonGenerator can flush ok.
     * @throws Exception If something goes worng.
     */
    @Test
    public void flushesOk() throws Exception {
        final Writer writer = Mockito.mock(Writer.class);
        Mockito.doNothing().when(writer).flush();
        final JsonGenerator gen = new RtJsonGenerator(writer);
        gen.flush();
        Mockito.verify(writer, Mockito.times(1)).flush();
    }
    
    /**
     * RtJsonGenerator catches and rethrows the IOException from writer.flush().
     * @throws Exception If something goes worng.
     */
    @Test
    public void flusheThrowsException() throws Exception {
        final Writer writer = Mockito.mock(Writer.class);
        Mockito.doThrow(new IOException("#flush()")).when(writer).flush();
        final JsonGenerator gen = new RtJsonGenerator(writer);
        try {
            gen.flush();
        } catch (final IllegalStateException ex) {
            Mockito.verify(writer, Mockito.times(1)).flush();
            return;
        }
        Assert.fail("#flush() should have thrown IllegalStateException!");
    }
    
    /**
     * RtJsonGenerator can close ok.
     * @throws Exception If something goes worng.
     */
    @Test
    public void closesOk() throws Exception {
        final Writer writer = Mockito.mock(Writer.class);
        Mockito.doNothing().when(writer).close();
        final JsonGenerator gen = new RtJsonGenerator(writer);
        gen.close();
        Mockito.verify(writer, Mockito.times(1)).close();
    }
    
    /**
     * RtJsonGenerator catches and rethrows the IOException from writer.flush().
     * @throws Exception If something goes worng.
     */
    @Test
    public void closeThrowsException() throws Exception {
        final Writer writer = Mockito.mock(Writer.class);
        Mockito.doThrow(new IOException("#close()")).when(writer).close();
        final JsonGenerator gen = new RtJsonGenerator(writer);
        try {
            gen.close();
        } catch (final IllegalStateException ex) {
            Mockito.verify(writer, Mockito.times(1)).close();
            return;
        }
        Assert.fail("#close() should have thrown IllegalStateException!");
    }
    
    /**
     * RtJsonGenerator catches and rethrows the IOException when trying to start
     * a JsonArray.
     * @throws Exception If something goes worng.
     */
    @Test
    public void startArrayThrowsIoException() throws Exception {
        final Writer writer = Mockito.mock(Writer.class);
        Mockito.doThrow(new IOException("#startArray()"))
            .when(writer).write("[");
        final JsonGenerator gen = new RtJsonGenerator(writer);
        try {
            gen.writeStartArray();
        } catch (final IllegalStateException ex) {
            Mockito.verify(writer, Mockito.times(1)).write("[");
            return;
        }
        Assert.fail(
            "#writeStartArray() should have thrown IllegalStateException!"
        );
    }
    
    /**
     * RtJsonGenerator catches and rethrows the IOException when trying to start
     * a JsonArray.
     * @throws Exception If something goes worng.
     */
    @Test
    public void startObjectThrowsIoException() throws Exception {
        final Writer writer = Mockito.mock(Writer.class);
        Mockito.doThrow(new IOException("#startObject()"))
            .when(writer).write("{");
        final JsonGenerator gen = new RtJsonGenerator(writer);
        try {
            gen.writeStartObject();
        } catch (final IllegalStateException ex) {
            Mockito.verify(writer, Mockito.times(1)).write("{");
            return;
        }
        Assert.fail(
            "#writeStartArray() should have thrown IllegalStateException!"
        );
    }
    
}
