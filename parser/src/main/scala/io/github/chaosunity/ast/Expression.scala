package io.github.chaosunity.ast

sealed abstract class Expression
object Expression:
  case class IntegerVal(value: Int) extends Expression
