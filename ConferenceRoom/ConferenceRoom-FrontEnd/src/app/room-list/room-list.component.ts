import { Component, OnInit } from '@angular/core';
import { RoomDetailsComponent } from '../room-details/room-details.component';
import { Observable, Subscriber } from 'rxjs';
import { RoomService } from '../room.service';
import { room } from '../model/room';
import { Router } from '@angular/router';


@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms: Observable<room[]> | undefined;
  
  constructor(private roomService: RoomService, private router:Router) {}

  ngOnInit(): void {
    this.reloadData();
  }


  reloadData() {
    this.rooms=this.roomService.gerRoomList();
  }

  deleteRoom(id: number){
    this.roomService.deleteRoom(id)
    .subscribe(
      data => {
        console.log(data)
        this.reloadData();
      },

      error => console.log(error);

    )

  }

  roomDetails(id: number){
    this.router.navigate(['datils',id]);
  }

  updateRoom(id: number){
    this.router.navigate(['update', id]);
  }

}
