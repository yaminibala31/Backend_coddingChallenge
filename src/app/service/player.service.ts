import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Player } from 'src/model/Player';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class PlayerService {

baseUrl:string="http://localhost:8082/api/players/";

  constructor(private http:HttpClient) { }

  insertPlayer(body:Player):Observable<Player[]>{

    console.log(body);
    return this.http.post<Player[]>(this.baseUrl+"add",body);

  }

  updatePlayer(player:Player):Observable<Player[]>{

    console.log(player);
    return this.http.put<Player[]>(this.baseUrl+"update",player);

  }

  getAll():Observable<Player[]>{
    return this.http.get<Player[]>(this.baseUrl+"getall");
  }


  delete(playerId:number):Observable<string>{
      return  this.http.delete<string>(this.baseUrl+`delete/${playerId}`);

    }


    find(data:string):Observable<Player[]>{
      console.log(data)
     return this.http.get<Player[]>(this.baseUrl+`get/teamName/${data}`);

    }
}
