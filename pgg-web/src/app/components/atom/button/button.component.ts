import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IAttributes } from '../../global/models';
import { addStylesUtil } from '../../global/utils';

interface ICButtonpProps {
  color: 'primary' | 'accent' | 'warn';
  text: string;
}

@Component({
  selector: 'CButton',
  template: '<button id="btn" class="" mat-flat-button color={{props.color}} (click)="onClick()">{{props.text}}</button>',
  styleUrls: ['./button.component.scss'],
})
export class CButtonComponent implements OnInit {
  @Input() props: ICButtonpProps = {
    color: 'primary',
    text: 'button',
  };
  @Input() classes?: Array<string> = [];
  @Input() styles?: IAttributes;
  @Output() click: EventEmitter<void> = new EventEmitter<void>();

  ngOnInit(): void {
    this.addClassesComponent();
    addStylesUtil(this.styles,"btn")
  }

  onClick() {
    this.click.emit();
  }

  addClassesComponent() {
    const button = document.getElementById('btn');
    if (button != null && this.classes != null && this.classes.length > 0) {
      this.classes.forEach((c) => button.classList.add(c));
    }
  }
}
