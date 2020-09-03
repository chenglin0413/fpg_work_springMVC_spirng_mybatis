  	/*
    0.將tbody上的tr全部加入draggble 屬性
    1.將tr 上增加dragstart,drop,dragenter,dragend功能
    */
    function select_all_tr_add_draggble_evnetlistener(){
        let items = document.querySelectorAll('.tbody > .tr');
        items.forEach(item => {
          add_draggble_eventlistener(item);
        });
    }
    function add_draggble_eventlistener(obj){
        $(obj).prop('draggable', true)
        obj.addEventListener('dragstart', drag_start)
        obj.addEventListener('drop', dropped)
        obj.addEventListener('dragenter', cancel_default)
        obj.addEventListener('dragover', cancel_default)
    }
    function drag_start (e) {
      let index = $(e.target).index()
      e.dataTransfer.setData('text/plain', index)
    }
    function dropped (e) {
      cancel_default(e)

      // get new and old index
      let oldIndex = e.dataTransfer.getData('text/plain')
      let target = $(e.target)
      console.log(target);
      let newIndex = target.index()

      // remove dropped items at old place
      let dropped = $(this).parent().children().eq(oldIndex).remove()

      // insert the dropped items at new place
      if (newIndex < oldIndex) {
        target.parents(".tr").before(dropped)
      } else {
        target.parents(".tr").after(dropped)
      }
    }
    function cancel_default (e) {
      e.preventDefault()
      e.stopPropagation()
      return false
    }