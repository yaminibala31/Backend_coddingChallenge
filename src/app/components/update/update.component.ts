import { Component } from '@angular/core';
import { PlayerService } from 'src/app/service/player.service';
import { Player } from 'src/model/Player';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {

  constructor(private  Service:PlayerService){}
  
    updatePlayer(data:Player){
      
          this.Service.updatePlayer(data)
          .subscribe(
            (response)=>{console.log('updated player : '+response);

              alert(" Player Updated successfully");
            }
            );
  
  
         
  
    }

}
