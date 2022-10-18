import { ActivatedRoute } from '@angular/router';
import { CursosService } from './../services/cursos.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-curso-form',
  templateUrl: './curso-form.component.html',
  styleUrls: ['./curso-form.component.scss']
})
export class CursoFormComponent implements OnInit {

form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private service: CursosService,
    private _snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({
      name: [null],
      category: [null]
    });
  }

  ngOnInit(): void {}
  
  onSubmit(){
    this.service.save(this.form.value)
    .subscribe(data => console.log(data), error => this.onError());
  }
  onCancel(){

  }

  private onError(){
    this._snackBar.open('Erro ao salvar curso', '', {duration: 5000});
  }

}
