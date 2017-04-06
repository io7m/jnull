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
 * <p>
 * An exception raised when a {@link NullCheck} assertion fails.
 * </p>
 * <p>
 * Exceptions of this type are <i>not</i> intended to be caught and handled;
 * they indicate program bugs.
 * </p>
 *
 * @see NullCheck
 */

public final class NullCheckException extends RuntimeException
{
  private static final long serialVersionUID;

  static {
    serialVersionUID = 4244597614638250953L;
  }

  /**
   * Construct an exception with the given message.
   *
   * @param message The message
   */

  public NullCheckException(
    final String message)
  {
    super("Null check failed: " + message);
  }

  /**
   * Construct an exception with the given cause and message.
   *
   * @param message The message
   * @param cause   The cause
   */

  public NullCheckException(
    final String message,
    final Throwable cause)
  {
    super("Null check failed: " + message, cause);
  }
}
