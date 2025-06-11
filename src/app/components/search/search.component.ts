import { Component, PlatformRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlayerService } from 'src/app/service/player.service';
import { Player } from 'src/model/Player';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  SearchList:Player[] =[];

    constructor(private route:ActivatedRoute, private Service:PlayerService){}
 
    ngOnInit(): void {
     
      this.find();
  }
   
     searchInput:string = '';

    find(){

          // Here we search employees records , whose salary is greater than input = 15000 or input = 50000

        this.route.params.subscribe( (param)=>{ this.searchInput = param['input']});

        this.Service.find(this.searchInput).subscribe( (list)=> {this.SearchList = list;console.log('list '+list)});
       
        console.log('serached data '+this.SearchList);

    }

}
