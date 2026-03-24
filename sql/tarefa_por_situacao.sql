SELECT
    DATE (h.DATA_HORA) AS dia, t.SITUACAO AS situacao_codigo, ts.DESCRICAO AS situacao_descricao, COUNT (DISTINCT h.ID_LOJA, h.ID_TAREFA) AS total_tarefas
FROM HISTORICO h
    INNER JOIN TAREFA t
ON t.ID_LOJA = h.ID_LOJA
    AND t.ID_TAREFA = h.ID_TAREFA
    AND t.TIPO = 1
GROUP BY
    DATE (h.DATA_HORA),
    t.SITUACAO
ORDER BY
    dia,
    situacao_codigo;