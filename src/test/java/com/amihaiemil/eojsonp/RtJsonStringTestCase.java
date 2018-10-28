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

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import javax.json.JsonValue;

/**
 * Unit tests for {@link RtJsonString}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RtJsonStringTestCase {

    /**
     * RtJsonString can return the encapsulated String.
     */
    @Test
    public void getsTheString() {
        MatcherAssert.assertThat(
            new RtJsonString("test").getString(),
            Matchers.equalTo("test")
        );
    }

    /**
     * RtJsonString can return the encapsulated String as CharSequence.
     */
    @Test
    public void getsTheCharSequence() {
        MatcherAssert.assertThat(
            new RtJsonString("test").getChars(),
            Matchers.equalTo("test")
        );
    }

    /**
     * RtJsonString's value type is ValueType.STRING.
     */
    @Test
    public void valueTypeIsString() {
        MatcherAssert.assertThat(
            new RtJsonString("test").getValueType(),
            Matchers.equalTo(JsonValue.ValueType.STRING)
        );
    }

    /**
     * RtJsonString can return its hashcode.
     */
    @Test
    public void hasHashCode() {
        MatcherAssert.assertThat(
            new RtJsonString("test").hashCode(),
            Matchers.equalTo("test".hashCode())
        );
    }

    /**
     * RtJsonString prints itself with quotes.
     */
    @Test
    public void printsWithQuotes() {
        MatcherAssert.assertThat(
            new RtJsonString("test").toString(),
            Matchers.equalTo("\"test\"")
        );

        MatcherAssert.assertThat(
            new RtJsonString(null).toString(),
            Matchers.equalTo("\"null\"")
        );
    }

    /**
     * RtJsonString can compare itself to others.
     */
    @Test
    public void equalsWorks() {
        MatcherAssert.assertThat(
            new RtJsonString("test"),
            Matchers.equalTo(new RtJsonString("test"))
        );

        MatcherAssert.assertThat(
            new RtJsonString("test"),
            Matchers.not(
                Matchers.equalTo(new RtJsonString("test2"))
            )
        );

        MatcherAssert.assertThat(
            new RtJsonString("test"),
            Matchers.not(
                Matchers.equalTo("test")
            )
        );

        MatcherAssert.assertThat(
            new RtJsonString("test"),
            Matchers.not(
                Matchers.equalTo(null)
            )
        );

        MatcherAssert.assertThat(
            new RtJsonString(null),
            Matchers.not(
                Matchers.equalTo(new RtJsonString("test"))
            )
        );

        final RtJsonString same = new RtJsonString("same");
        MatcherAssert.assertThat(
            same, Matchers.equalTo(same)
        );
    }
}
