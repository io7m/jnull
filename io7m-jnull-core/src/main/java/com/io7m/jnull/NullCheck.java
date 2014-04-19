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

/**
 * Functions for enforcing non-nullable references at run time.
 */

public final class NullCheck
{
  /**
   * Check that <code>x</code> is not null, raising
   * {@link NullPointerException} iff <code>x == null</code>.
   * 
   * @param <T>
   *          The type of values
   * @param x
   *          An arbitrary value
   * @return <code>x</code>
   */

  @SuppressWarnings("null") public static @NonNull <T> T notNull(
    final @Nullable T x)
  {
    if (x == null) {
      throw new NullPointerException(
        "Null check failed: expression evaluated to null");
    }
    return x;
  }

  /**
   * Check that <code>x</code> is not null, raising
   * {@link NullPointerException} iff <code>x == null</code>.
   * 
   * @param <T>
   *          The type of values
   * @param x
   *          An arbitrary value
   * @param message
   *          A descriptive message describing the value
   * @return <code>x</code>
   */

  @SuppressWarnings("null") public static @NonNull <T> T notNull(
    final @Nullable T x,
    final @NonNull String message)
  {
    if (x == null) {
      final StringBuilder text = new StringBuilder();
      text.append("Null check failed: expression evaluated to null: ");
      text.append(message);
      throw new NullPointerException(text.toString());
    }
    return x;
  }

  private NullCheck()
  {
    throw new RuntimeException("Unreachable code");
  }
}
