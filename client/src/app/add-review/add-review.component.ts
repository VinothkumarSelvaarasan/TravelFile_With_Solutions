import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-addreview',
  templateUrl: './add-review.component.html'
 
})
export class AddReviewComponent {
  itemForm: FormGroup;
  reviewData: any={};
  locationData:any={};
  showError:boolean=false;
  errorMessage:any;
  formModel:any={status:null};
  cargList:any=[];
  assignModel: any={};
  driverList:any=[]
  showMessage: any;
  responseMessage: any;
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService)
  {
    this.itemForm = this.formBuilder.group({
      statenam: [this.formModel.statenam,[ Validators.required]],
      location: [this.formModel.location,[ Validators.required]],
      highLights: [this.formModel.highLights,[ Validators.required]]
    });
  }

  callLocation()
  {
    // console.log("testing");
    // console.log(this.itemForm.value.statenam);
debugger;
      this.locationData={};
      this.httpService.getLocationData(this.itemForm.value.statenam).subscribe((data: any) => {
        console.log(this.reviewData.statenam);
        this.locationData=data;
        console.log(this.locationData);
      }, error => {
        // Handle error
        this.showError = true;
        this.errorMessage = "An error occurred while searching in. Please try again later or no record found";
        console.error('Login error:', error);
      });;
    }
  
  onSubmit()
  {

  }
}
