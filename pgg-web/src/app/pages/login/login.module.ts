import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { LoginComponent } from "./login.component";


import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "src/app/SharedModule";
import { ComponentsModule } from "../../components/ComponentsModule";
import { TranslateModule } from "@ngx-translate/core";

const routes = [
    {
        path: 'login',
        component: LoginComponent,
        // resolve  : {
        //     academy: AcademyCoursesService
        // }
    }
];


@NgModule({
    declarations: [
        LoginComponent,
    ],
    imports: [
        RouterModule.forChild(routes),
        MatGridListModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        FormsModule,
        ReactiveFormsModule,
        SharedModule,
        ComponentsModule, 
        TranslateModule
    ]
})
export class LoginModule {
}