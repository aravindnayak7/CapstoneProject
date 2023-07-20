import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Rooms } from '../roomservice/roomd';

@Injectable({
  providedIn: 'root'
})

export class RoomServiceService {

  SaveRoomDetails(roomdata: { roomId:string, roomName: string; capacity: number; location: string; price: number; }) {
    throw new Error('Method not implemented.');
  }

  private baseurl:string="http://localhost:8084/room/";
  constructor(private http:HttpClient) { }

  addroomdata(roomdata:any)
  {
    return this.http.post(`${this.baseurl}SaveRoomDetails`,roomdata)
  }

  getRoomDetails():Observable<Rooms[]> 
  {
    return this.http.get<Rooms[]>(`${this.baseurl}getAllRoomDetails`)
  }

  getRoomById(id: Number) 
  {
    return this.http.get<Rooms>(`${this.baseurl}getRoomDetailsById/${id}`);
  }

  updateRoom(id:Number, room: Rooms)
  {
    return this.http.put<Rooms>(`${this.baseurl}updateRoomDetails/${id}`, room);
  }
}