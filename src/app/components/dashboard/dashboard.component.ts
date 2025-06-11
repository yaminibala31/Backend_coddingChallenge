import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  data:string = '';

    constructor(private Service:PlayerService,private router:Router){}
   
      // find(searchData:any){

      //     this.router.navigate(['/search/'+searchData.form.value.data])

      //     console.log(searchData.form.value.data);
          

      // }
      
      find(data: string) {
  const trimmed = data.trim();
  if (!trimmed) {
    alert("Please enter a valid search term.");
    return;
  }

  console.log("Navigating to:", trimmed);
  this.router.navigate(['/search', trimmed]);
}

}
