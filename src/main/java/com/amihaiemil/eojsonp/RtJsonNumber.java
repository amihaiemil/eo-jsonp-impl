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
import java.util.Objects;
import javax.json.JsonNumber;

/**
 * Base JsonNumber implementation. Rt stands for "runtime".
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
final class RtJsonNumber implements JsonNumber {

    /**
     * This JsonNumber's value as BigDecimal (see {@link JsonNumber} javadoc).
     */
    private final BigDecimal value;
    
    /**
     * Ctor.
     * @param value This JsonNumber's value as String.
     */
    RtJsonNumber(final String value) {
        this.value = new BigDecimal(value);
    }
    
    @Override
    public boolean isIntegral() {
        final int afterComma = this.value.scale();
        return afterComma == 0;
    }

    @Override
    public int intValue() {
        return this.value.intValue();
    }

    @Override
    public int intValueExact() {
        return this.value.intValueExact();
    }

    @Override
    public long longValue() {
        return this.value.longValue();
    }

    @Override
    public long longValueExact() {
        return this.value.longValueExact();
    }

    @Override
    public BigInteger bigIntegerValue() {
        return this.value.toBigInteger();
    }

    @Override
    public BigInteger bigIntegerValueExact() {
        return this.value.toBigIntegerExact();
    }

    @Override
    public double doubleValue() {
        return this.value.doubleValue();
    }

    @Override
    public BigDecimal bigDecimalValue() {
        return this.value;
    }

    @Override
    public ValueType getValueType() {
        return ValueType.NUMBER;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof JsonNumber)) {
            return false;
        }
        final RtJsonNumber other = (RtJsonNumber) obj;
        return this.value.equals(other.value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
    
}
