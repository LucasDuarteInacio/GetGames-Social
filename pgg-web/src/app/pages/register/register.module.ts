import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";


import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { SharedModule } from "src/app/SharedModule";
import { RegisterComponent } from "./register.component";
import { ComponentsModule } from "src/app/components/ComponentsModule";
import { TranslateLoader, TranslateModule } from "@ngx-translate/core";

const routes = [
    {
        path: '',
        component: RegisterComponent,
        // resolve  : {
        //     academy: AcademyCoursesService
        // }
    }
];


@NgModule({
    declarations: [
        RegisterComponent,
    ],
    imports: [
        RouterModule.forChild(routes),
        MatGridListModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        FormsModule,
        ReactiveFormsModule,
        ComponentsModule,
        SharedModule,
        TranslateModule
    ],
    // providers   : [
    //     AcademyCoursesService,
    //     AcademyCourseService
    // ]

})
export class RegisterModule {
}