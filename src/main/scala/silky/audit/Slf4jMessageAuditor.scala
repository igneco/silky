package silky.audit

import org.slf4j.LoggerFactory.getLogger
import silky.MessageFlowId

class Slf4jMessageAuditor(defaultLoggerName: String, formatter: Formatter) extends MessageAuditor {

  def audit(messageFlowId: MessageFlowId, auditMessage: AuditMessage): Unit =
    auditToNamedLog(defaultLoggerName, messageFlowId, auditMessage)

  def auditToNamedLog(auditLogName: String, messageFlowId: MessageFlowId, auditMessage: AuditMessage): Unit =
    getLogger(auditLogName).info(formatter.format(messageFlowId, auditMessage))
}
