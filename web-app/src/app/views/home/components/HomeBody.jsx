import React from 'react';
import {
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
  Card
} from "@material-ui/core";
  
import {data} from '../../../data';

const HomeBody = (props) => {
  return (
    <div style={{justifyContent: 1, display: 'flex', margin: 50}}>
      <Card className="w-full overflow-auto" elevation={6}>
          <div className="p-12">
            <Table className="crud-table whitespace-pre min-w-3000">
              <TableHead>
                <TableRow>
                  <TableCell>codigoEmenda</TableCell>
                  <TableCell>ano</TableCell>
                  <TableCell>autor</TableCell>
                  <TableCell>nomeAutor</TableCell>
                  <TableCell>localidadeDoGasto</TableCell>
                  <TableCell>funcao</TableCell>
                  <TableCell>subfuncao</TableCell>
                  <TableCell>valorEmpenhado</TableCell>
                  <TableCell>valorLiquidado</TableCell>
                  <TableCell>valorPago</TableCell>
                  <TableCell>valorRestoInscrito</TableCell>
                  <TableCell>valorRestoCancelado</TableCell>
                  <TableCell>valorRestoPago</TableCell>
                  <TableCell>valorRestoAPagar</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {data.map((it, index) => (
                    <TableRow key={index}>
                      <TableCell>{it.codigoEmenda}</TableCell>
                      <TableCell>{it.ano}</TableCell>
                      <TableCell>{it.autor}</TableCell>
                      <TableCell>{it.nomeAutor}</TableCell>
                      <TableCell>{it.localidadeDoGasto}</TableCell>
                      <TableCell>{it.funcao}</TableCell>
                      <TableCell>{it.subfuncao}</TableCell>
                      <TableCell>{it.valorEmpenhado}</TableCell>
                      <TableCell>{it.valorLiquidado}</TableCell>
                      <TableCell>{it.valorPago}</TableCell>
                      <TableCell>{it.valorRestoInscrito}</TableCell>
                      <TableCell>{it.valorRestoCancelado}</TableCell>
                      <TableCell>{it.valorRestoPago}</TableCell>
                      <TableCell>{it.valorRestoAPagar}</TableCell>
                    </TableRow>
                  ))}
              </TableBody>
            </Table>
          </div>
        </Card>
    </div>
  )
}

export default HomeBody;