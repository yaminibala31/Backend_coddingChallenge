import { Component } from '@angular/core';
import { PlayerService } from 'src/app/service/player.service';
import { Player } from 'src/model/Player';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent {

  constructor(private  Service:PlayerService){}

  insertPlayer(data:Player){
    
        this.Service.insertPlayer(data)
        .subscribe(
          (Player)=>{console.log('Added Player is: '+Player);
            alert(" Player added successfully");
          }
          );


       

  }

}
