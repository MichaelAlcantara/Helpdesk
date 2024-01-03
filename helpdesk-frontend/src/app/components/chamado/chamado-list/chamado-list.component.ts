import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Chamado } from 'src/app/models/chamado';
import { ChamadoService } from 'src/app/services/chamado.service';

@Component({
  selector: 'app-chamado-list',
  templateUrl: './chamado-list.component.html',
  styleUrls: ['./chamado-list.component.css']
})
export class ChamadoListComponent implements OnInit {

  ELEMENT_DATA: Chamado[] = []
  FILTERED_DATA: Chamado[] = []

  constructor(private service : ChamadoService) { }

  ngOnInit(): void {
    this.findAll();
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[] = ['id', 'titulo', 'nomeCliente', 'nomeTecnico', 'dataAbertura', "prioridade", 'status', 'acoes'];
  dataSource = new MatTableDataSource<Chamado>(this.ELEMENT_DATA);
  
  findAll(){
    this.service.findAll().subscribe(reposta =>{
      this.ELEMENT_DATA = reposta
      this.dataSource = new MatTableDataSource<Chamado>(this.ELEMENT_DATA);
      this.dataSource.paginator = this.paginator;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  retornaStatus(status: any) : string{
    if(status == '0'){
      return 'ABERTO'
    }else if( status == 1){
      return 'EM ANDAMENTO'
    }else {
      return 'ENCERRADO'
    }
  }

  retornaPrioridade(prioridade: any) : string{
    if(prioridade == '0'){
      return 'BAIXA'
    }else if( prioridade == 1){
      return 'MÉDIA'
    }else {
      return 'ALTA'
    }
  }

  orderByStatus(status: any) : void{
    let list: Chamado[] = [];
    this.ELEMENT_DATA.forEach(
      element =>{
        if(element.status == status){
          list.push(element);
        }
        this.FILTERED_DATA = list;
        this.dataSource = new MatTableDataSource<Chamado>(this.FILTERED_DATA);
        this.dataSource.paginator = this.paginator;
      }
    )
  }
}
