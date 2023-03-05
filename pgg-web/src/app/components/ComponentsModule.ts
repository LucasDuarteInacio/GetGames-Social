import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { CButtonComponent } from './atom/button/button.component';

@NgModule({
    declarations: [
        CButtonComponent,
    ],
    imports: [
        MatButtonModule,
    ],
    exports: [
        CButtonComponent

    ]
})
export class ComponentsModule {
}
