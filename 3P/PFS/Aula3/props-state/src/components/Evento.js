import React from "react";

class Evento extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="event">
        <div className="label">
          <img src={this.props.fotoPerfil} alt="..." />
        </div>
        <div className="content">
          <div className="summary">
            <a className="user">{this.props.nome}</a> {this.props.mensagem}
            <div className="date">{this.props.tempo} minutos atrás</div>
          </div>
          <div className="meta">
            <a className="like">
              <i className="like icon"></i> {this.props.likes} Likes
            </a>
          </div>
        </div>
      </div>
    );
  }
}

export default Evento;

// const Evento = (props) => {
//     return (
//         <div className="event">
//             <div className="label">
//                 <img src={props.fotoPerfil} alt="..." />
//             </div>
//             <div className="content">
//                 <div className="summary">
//                     <a className="user">
//                         {this.props.nome}
//                     </a> {props.mensagem}
//                     <div className="date">
//                         {props.tempo} minutos atrás
//                     </div>
//                 </div>
//                 <div className="meta">
//                     <a className="like">
//                         <i className="like icon"></i> {props.likes} Likes
//                     </a>
//                 </div>
//             </div>
//         </div>
//     );
// };

// export default Evento;
