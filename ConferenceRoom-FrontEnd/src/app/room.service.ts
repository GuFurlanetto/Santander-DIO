import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Room } from './model/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8082/api/v1/rooms';

  constructor(private http: HttpClient){}

  updateRoom(id: number, room: Room, value: any) : Observable<Object>{
    return this.http.put('${this.baseUrl}/${id}', value);
    
  }
  getRoom(id: number) : Observable <any>{
    return this.http.get('${this.baseUrl}/${id}');
  }

  createRoom(room: Room) {
    return this.http.post('${this.baseUrl}',room);
  }

  deleteRoom(id: number) : Observable<any>{
    return this.http.delete('${this.baseUrl}/${id}', {respondeType: 'text'});
  }
  gerRoomList(): Observable<any> {
    return this.http.get('${this.baseUrl}');
  }

}
