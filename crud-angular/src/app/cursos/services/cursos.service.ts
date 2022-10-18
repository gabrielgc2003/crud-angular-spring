import { Injectable } from '@angular/core';
import { Cursos } from '../model/cursos';
import { HttpClient } from '@angular/common/http';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  private readonly API = 'api/cursos'

  constructor(private httpClient: HttpClient) {}

  list() {
    return this.httpClient.get<Cursos[]>(this.API)
    .pipe(
      first(),
      delay(1000),
      tap(cursos => console.log(cursos))
    );
  }

  save(record: Cursos){
  return this.httpClient.post<Cursos>(this.API, record).pipe(first());
  }
}
