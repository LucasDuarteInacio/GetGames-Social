function addStylesUtil(styles2:any, id:any) {
    const button = document.getElementById(id);
    if (styles2 && button != null) {
      const styles = styles2[0];
      const stylesArray = Object.entries(styles);
      stylesArray.forEach((e: any) => {
        const key: string = e[0];
        const value: string = e[1];

        button.style.setProperty(key, value);
      });
    }
  }

  export {addStylesUtil};