import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';

import { Cursos } from '../model/cursos';
import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { CursosService } from './../services/cursos.service';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']
})
export class CursosComponent implements OnInit {

  public cursos$: Observable <Cursos[]>;
  public displayedColumns = ['name', 'category']

   // cursosService: CursosService;

  constructor(
    private cursosService: CursosService,
    public dialog: MatDialog) {
    // this.cursosService = new CursosService();
    this.cursos$ = this.cursosService.list().pipe(
    catchError(error => {
      this.OnError('Erro ao carregar cursos.');
      return of([])
    })
   );
  }

  OnError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void { }

}
