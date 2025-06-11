import { Component } from '@angular/core';
import { PlayerService } from 'src/app/service/player.service';
import { Player } from 'src/model/Player';

@Component({
  selector: 'app-dispaly',
  templateUrl: './dispaly.component.html',
  styleUrls: ['./dispaly.component.css']
})
export class DispalyComponent {


  playerList:Player[] = [];
  constructor(private Service:PlayerService){}
  
  ngOnInit(){

    this.getAllPlayers();

  }


  getAllPlayers(){
    
      this.Service.getAll().subscribe( 
         (list)=>{ this.playerList = list;  console.log(list)}
                                
      );

          

 }

  deleteById(playerId:number){

        this.Service.delete(playerId).subscribe( (msg)=>{ console.log("Deleted "+msg);});  
        this.getAllPlayers(); // to refresh list again

       

  }

}
