import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Potion } from '../models/potion';

@Injectable({
  providedIn: 'root'
})
export class PotionService {
  private api = 'http://localhost:8080/api/potions'; 

  constructor(private http: HttpClient) { }

  getAll(): Observable<Potion[]>{
    return this.http.get<Potion[]>(this.api);
  }
  
  getOne(id: number): Observable<Potion> {
    return this.http.get<Potion>(`${this.api}/${id}`);
  }

  create(data: { title: string; description?: string}){
    return this.http.post<Potion>(this.api, data);
  }

  delete(id: number){
    return this.http.delete<void>(`${this.api}/${id}`);
  }
  
  addIngredient(potionId: number, title: string, deadline?:string): Observable<Potion>{
    return this.http.post<Potion>(`${this.api}/${potionId}/ingredients`, {title, deadline});
  }

  toggleIngredient(potionId: number, ingredientId: number): Observable<Potion>{
    return this.http.patch<Potion>(`${this.api}/${potionId}/ingredients/${ingredientId}/toggle`, {});
  }

  getStats(): Observable<{ totalPotions: number; completedPotions: number; incompletePotions: number; totalPoints: number }> {
    return this.http.get<any>(`${this.api}/stats`);
  }
}
