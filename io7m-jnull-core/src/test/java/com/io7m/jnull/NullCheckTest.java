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

package com.io7m.jnull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("static-method") public final class NullCheckTest
{
  @Test public void testNotNull()
  {
    Assert.assertEquals("example", NullCheck.notNull("example"));
  }

  @Test public void testNotNullAll()
  {
    final List<Integer> xs = new ArrayList<Integer>();
    xs.add(Integer.valueOf(0));
    xs.add(Integer.valueOf(1));
    xs.add(Integer.valueOf(2));
    Assert.assertEquals(xs, NullCheck.notNullAll(xs));
  }

  @Test public void testNotNullAllMessage()
  {
    final List<Integer> xs = new ArrayList<Integer>();
    xs.add(Integer.valueOf(0));
    xs.add(Integer.valueOf(1));
    xs.add(Integer.valueOf(2));
    Assert.assertEquals(xs, NullCheck.notNullAll(xs, "Integers"));
  }

  @Test(expected = NullCheckException.class) public
    void
    testNotNullAllNull_0()
  {
    final List<Integer> xs = new ArrayList<Integer>();
    xs.add(Integer.valueOf(0));
    xs.add(null);
    xs.add(Integer.valueOf(2));
    Assert.assertEquals(xs, NullCheck.notNullAll(xs));
  }

  @Test(expected = NullCheckException.class) public
    void
    testNotNullAllNull_1()
  {
    NullCheck.notNullAll(null);
  }

  @Test(expected = NullCheckException.class) public
    void
    testNotNullAllNullMessage_0()
  {
    final List<Integer> xs = new ArrayList<Integer>();
    xs.add(Integer.valueOf(0));
    xs.add(null);
    xs.add(Integer.valueOf(2));
    Assert.assertEquals(xs, NullCheck.notNullAll(xs, "Integers"));
  }

  @Test(expected = NullCheckException.class) public
    void
    testNotNullAllNullMessage_1()
  {
    NullCheck.notNullAll(null, "Integers");
  }

  @Test public void testNotNullMessage()
  {
    Assert.assertEquals("example", NullCheck.notNull("example", "Message"));
  }

  @Test(expected = NullCheckException.class) public void testNull()
  {
    NullCheck.notNull(null);
  }

  @Test(expected = NullCheckException.class) public void testNullMessage()
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
}
