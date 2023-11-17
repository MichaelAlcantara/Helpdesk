import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tecnico } from 'src/app/models/tecnico';

@Component({
  selector: 'app-tecnico-list',
  templateUrl: './tecnico-list.component.html',
  styleUrls: ['./tecnico-list.component.css']
})
export class TecnicoListComponent implements OnInit {

  ELEMENT_DATA: Tecnico[] = [
    {
      id : 1,
      nome : 'Michael',
      cpf : '12345678910',
      email : "michael@email.com",
      senha : '123',
      perfis : ['0'],
      dataCriacao : '17/11/2023'
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

  displayedColumns: string[] = ['id', 'nome', 'cpf', 'email', "acoes"];
  dataSource = new MatTableDataSource<Tecnico>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

}