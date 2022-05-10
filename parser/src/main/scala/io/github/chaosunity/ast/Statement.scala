package io.github.chaosunity.ast

sealed abstract class Statement
object Statement:
  case class VariableDeclaration(declarationType: VariableDeclaration.DeclarationType, variableName: String, value: Expression) extends Statement
  object VariableDeclaration:
    enum DeclarationType(val finalized: Boolean):
      case LET extends DeclarationType(false)
      case CONST extends DeclarationType(true)
