/*
 * Copyright © 2014 <code@io7m.com> http://io7m.com
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jnull.tests;

import com.io7m.jnull.NullCheck;
import com.io7m.jnull.NullCheckException;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class NullCheckTest
{
  @Rule public final ExpectedException expected = ExpectedException.none();

  @Test
  public void testNotNullAllMessage()
  {
    final List<Integer> xs = new ArrayList<Integer>();
    xs.add(Integer.valueOf(0));
    xs.add(Integer.valueOf(1));
    xs.add(Integer.valueOf(2));
    Assert.assertEquals(xs, NullCheck.notNullAll(xs, "Integers"));
  }

  @Test
  public void testNotNullAllNullMessage0()
  {
    final List<Integer> xs = new ArrayList<Integer>();
    xs.add(Integer.valueOf(0));
    xs.add(null);
    xs.add(Integer.valueOf(2));

    this.expected.expect(NullCheckException.class);
    Assert.assertEquals(xs, NullCheck.notNullAll(xs, "Integers"));
    Assert.fail();
  }

  @Test
  public void testNotNullAllNullMessage1()
  {
    final Collection<Object> c = null;

    this.expected.expect(NullCheckException.class);
    NullCheck.notNullAll(c, "Integers");
    Assert.fail();
  }

  @Test
  public void testNotNullMessage()
  {
    Assert.assertEquals("example", NullCheck.notNull("example", "Message"));
  }

  @Test(expected = NullCheckException.class)
  public void testNullMessage()
  {
    try {
      NullCheck.notNull(null, "value");
    } catch (final NullPointerException x) {
      Assert.assertEquals(
        "Null check failed: expression evaluated to null: value",
        x.getMessage());
      throw x;
    }
  }

  @Test
  public void testNullExceptionCause()
  {
    final AssertionError ex = new AssertionError("Exception");
    final NullCheckException eex = new NullCheckException("Message", ex);
    Assert.assertEquals(eex.getCause(), ex);
  }

  @Test
  public void testNullCheckUnreachableConstructor()
    throws Exception
  {
    final Constructor<NullCheck> c =
      NullCheck.class.getDeclaredConstructor();
    c.setAccessible(true);

    this.expected.expect(InvocationTargetException.class);
    this.expected.expectCause(Is.isA(AssertionError.class));
    c.newInstance();
    Assert.fail();
  }
}
