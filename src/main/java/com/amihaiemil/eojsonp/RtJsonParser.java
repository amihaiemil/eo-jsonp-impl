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
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;

/**
 * Base JsonParser implementation. Rt stands for "runtime".
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
final class RtJsonParser implements JsonParser {

    /**
     * Read the Json from somewhere.
     */
    private final Reader reader;
    
    /**
     * Ctor.
     * @param input InputStream to read from.
     */
    RtJsonParser(final InputStream input) {
        this(new InputStreamReader(input));
    }
    
    /**
     * Ctor.
     * @param reader Provided reader.
     */
    RtJsonParser(final Reader reader) {
        this.reader = reader;
    }
    
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Event next() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isIntegralNumber() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getInt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getLong() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal getBigDecimal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonLocation getLocation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
