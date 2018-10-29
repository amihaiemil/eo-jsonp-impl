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
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Unit tests for {@link RtJsonNumber}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class RtJsonNumberTestCase {
    
    /**
     * RtJsonNumber is of ValueType NUMBER.
     */
    @Test
    public void valueTypeIsNumber() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").getValueType(),
            Matchers.equalTo(JsonValue.ValueType.NUMBER)
        );
    }
    
    /**
     * RtJsonNumber can return its hashcode.
     */
    @Test
    public void hasHashCode() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123456789").hashCode(),
            Matchers.notNullValue()
        );
    }
    
    /**
     * RtJsonNumber can print itself.
     */
    @Test
    public void toStringWorks() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123.54").toString(),
            Matchers.equalTo("123.54")
        );
    }
    
    /**
     * RtJsonNumber can tell if it's integral or not.
     */
    @Test
    public void isIntegralWorks() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").isIntegral(),
            Matchers.is(true)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").isIntegral(),
            Matchers.is(true)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456798").isIntegral(),
            Matchers.is(true)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456798.01").isIntegral(),
            Matchers.is(false)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("156.8").isIntegral(),
            Matchers.is(false)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123.000008008").isIntegral(),
            Matchers.is(false)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.99999999999998").isIntegral(),
            Matchers.is(false)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("1.99999999999999").isIntegral(),
            Matchers.is(false)
        );
    }
    
    /**
     * RtJsonNumber will throw an exception if #intValueExact() is called
     * and the rounding would cause loss of information.
     */
    @Test(expected = ArithmeticException.class)
    public void intValueExactComplains() {
        new RtJsonNumber("123.45").intValueExact();
    }
    
    /**
     * RtJsonNumber will throw an exception if #longValueExact() is called
     * and the rounding would cause loss of information.
     */
    @Test(expected = ArithmeticException.class)
    public void longValueExactComplains() {
        new RtJsonNumber("123456.01").longValueExact();
    }
    
    /**
     * RtJsonNumber can return its value as int.
     */
    @Test
    public void returnsIntValue() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").intValue(),
            Matchers.equalTo(123)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").intValue(),
            Matchers.equalTo(0)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").intValue(),
            Matchers.equalTo(-123)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123.589").intValue(),
            Matchers.equalTo(123)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").intValue(),
            Matchers.equalTo(0)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").intValue(),
            Matchers.equalTo(-123)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.00056").intValue(),
            Matchers.equalTo(0)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456.00056").intValue(),
            Matchers.equalTo(123456)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456.0").intValueExact(),
            Matchers.equalTo(123456)
        );
    }
    
    /**
     * RtJsonNumber can return its value as long.
     */
    @Test
    public void returnsLongValue() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").longValue(),
            Matchers.equalTo(123L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").longValue(),
            Matchers.equalTo(0L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456789").longValue(),
            Matchers.equalTo(123456789L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123.589").longValue(),
            Matchers.equalTo(123L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("+123.589").longValue(),
            Matchers.equalTo(123L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").longValue(),
            Matchers.equalTo(-123L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.00056").longValue(),
            Matchers.equalTo(0L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("1568942567.00056").longValue(),
            Matchers.equalTo(1568942567L)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("1568942567.0").longValueExact(),
            Matchers.equalTo(1568942567L)
        );
    }
    
    /**
     * RtJsonNumber can return its value as double.
     */
    @Test
    public void returnsDoubleValue() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").doubleValue(),
            Matchers.equalTo(123.0)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").doubleValue(),
            Matchers.equalTo(0.0)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("156.8").doubleValue(),
            Matchers.equalTo(156.8)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123.589").doubleValue(),
            Matchers.equalTo(123.589)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").doubleValue(),
            Matchers.equalTo(-123.0)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("+123.4").doubleValue(),
            Matchers.equalTo(+123.4)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.00056").doubleValue(),
            Matchers.equalTo(0.00056)
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.56").doubleValue(),
            Matchers.equalTo(0.56)
        );
    }
    
    /**
     * RtJsonNumber will throw an exception if #bigIntegerExact() is called
     * and the rounding would cause loss of information.
     */
    @Test(expected = ArithmeticException.class)
    public void bigIntegerValueExactComplains() {
        new RtJsonNumber("1234657498.45").bigIntegerValueExact();
    }
    
    /**
     * RtJsonNumber#bigIntegerExact() works fine if the rounding doesn't cause
     * any loss of information.
     */
    @Test
    public void bigIntegerValueExactWorks() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").bigIntegerValueExact(),
            Matchers.equalTo(new BigInteger("123"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").bigIntegerValueExact(),
            Matchers.equalTo(new BigInteger("0"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456789.0").bigIntegerValueExact(),
            Matchers.equalTo(new BigInteger("123456789"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("+123.0").bigIntegerValueExact(),
            Matchers.equalTo(new BigInteger("+123"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").bigIntegerValueExact(),
            Matchers.equalTo(new BigInteger("-123"))
        );
    }
    
    /**
     * RtJsonNumber can return its value as BigInteger.
     */
    @Test
    public void returnsBigIntegerValue() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("123"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("0"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456789").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("123456789"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123.589").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("123"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("+123.589").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("+123"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("-123"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.00056").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("0"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("1568942567.00056").bigIntegerValue(),
            Matchers.equalTo(new BigInteger("1568942567"))
        );
    }
    
    /**
     * RtJsonNumber can return its value as BigDecimal.
     */
    @Test
    public void returnsBigDecimalValue() {
        MatcherAssert.assertThat(
            new RtJsonNumber("123").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal(123))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal(0))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123456789").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal(123456789))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("123.589").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal("123.589"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("-123").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal(-123))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("0.00056").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal("0.00056"))
        );
        
        MatcherAssert.assertThat(
            new RtJsonNumber("1568942567.00056").bigDecimalValue(),
            Matchers.equalTo(new BigDecimal("1568942567.00056"))
        );
    }
    
}
