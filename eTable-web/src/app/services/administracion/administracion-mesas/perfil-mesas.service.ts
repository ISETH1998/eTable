import { Injectable } from '@angular/core';
import { PerfilMesa } from 'src/app/domain/PerfilMesa';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PerfilMesasService {

  private url: string;
  constructor(private http: HttpClient) {
    this.url = 'etable/api/perfilMesa';
  }

  getPerfilesMesa() {
    return this.http.get<PerfilMesa[]>(this.url + '/' + 'listPerfilMesas');
  }

  public crearPerfilMesa (perfilMesa: PerfilMesa) {
    return this.http.post<PerfilMesa>(this.url + '/' + 'perfilMesa', perfilMesa);
  }
}
