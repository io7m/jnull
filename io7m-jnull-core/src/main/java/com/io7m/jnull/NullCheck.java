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

import java.util.Collection;
import java.util.Iterator;

/**
 * <p>
 * Functions for enforcing non-nullable references at run time.
 * </p>
 * <p>
 * The functions are intended for use in the manner of assertions. That is,
 * the program should behave identically if all of the checks are removed. The
 * functions raise {@link NullCheckException} to indicate that a null
 * reference has been explicitly forbidden (rather than the accidental
 * deference implied by {@link NullPointerException}). Exceptions of this type
 * are <i>not</i> intended to be caught and handled; they indicate program
 * bugs.
 * </p>
 * 
 * @see NullCheckException
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
      throw new NullCheckException("Expression evaluated to null");
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
      text.append("Expression evaluated to null: ");
      text.append(message);
      throw new NullCheckException(text.toString());
    }
    return x;
  }

  /**
   * Check that <code>x</code> is not null, and that all elements of
   * <code>x</code> are not null, raising {@link NullPointerException} iff
   * <code>x == null</code>.
   * 
   * @param <T>
   *          The type of values
   * @param <U>
   *          The type of collections of <code>T</code>
   * @param x
   *          An arbitrary value
   * @return <code>x</code>
   */

  @SuppressWarnings("null") public static @NonNull
    <T, U extends Collection<T>>
    U
    notNullAll(
      final @Nullable U x)
  {
    if (x == null) {
      final StringBuilder text = new StringBuilder();
      text.append("Expression evaluated to null");
      throw new NullCheckException(text.toString());
    }

    int index = 0;
    final Iterator<T> iter = x.iterator();
    while (iter.hasNext()) {
      final T z = iter.next();
      if (z == null) {
        final StringBuilder text = new StringBuilder();
        text.append("Expression ");
        text.append(" [");
        text.append(index);
        text.append("] evaluated to null");
        throw new NullCheckException(text.toString());
      }
      index = index + 1;
    }

    return x;
  }

  /**
   * Check that <code>x</code> is not null, and that all elements of
   * <code>x</code> are not null, raising {@link NullPointerException} iff
   * <code>x == null</code>.
   * 
   * @param <T>
   *          The type of values
   * @param <U>
   *          The type of collections of <code>T</code>
   * @param x
   *          An arbitrary value
   * @param message
   *          A descriptive message describing the value
   * @return <code>x</code>
   */

  @SuppressWarnings("null") public static @NonNull
    <T, U extends Collection<T>>
    U
    notNullAll(
      final @Nullable U x,
      final @NonNull String message)
  {
    if (x == null) {
      final StringBuilder text = new StringBuilder();
      text.append("Expression evaluated to null: ");
      text.append(message);
      throw new NullCheckException(text.toString());
    }

    int index = 0;
    final Iterator<T> iter = x.iterator();
    while (iter.hasNext()) {
      final T z = iter.next();
      if (z == null) {
        final StringBuilder text = new StringBuilder();
        text.append("Expression ");
        text.append(message);
        text.append(" [");
        text.append(index);
        text.append("] evaluated to null");
        throw new NullCheckException(text.toString());
      }
      index = index + 1;
    }

    return x;
  }

  private NullCheck()
  {
    throw new AssertionError("Unreachable code");
  }
}
