namespace MoodByte
{
    partial class AdminArticulos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            btnNuevoArticulo = new Button();
            btnEditarArticulo = new Button();
            btnBorrarArticulo = new Button();
            imageList1 = new ImageList(components);
            listViewArticulos = new ListView();
            pictureBoxArticulo = new PictureBox();
            panelTituloArticulo = new Panel();
            lblTitulo = new Label();
            ((System.ComponentModel.ISupportInitialize)pictureBoxArticulo).BeginInit();
            panelTituloArticulo.SuspendLayout();
            SuspendLayout();
            // 
            // btnNuevoArticulo
            // 
            btnNuevoArticulo.Location = new Point(66, 395);
            btnNuevoArticulo.Name = "btnNuevoArticulo";
            btnNuevoArticulo.Size = new Size(75, 23);
            btnNuevoArticulo.TabIndex = 1;
            btnNuevoArticulo.Text = "Nuevo";
            btnNuevoArticulo.UseVisualStyleBackColor = true;
            btnNuevoArticulo.Click += btnNuevoArticulo_Click;
            // 
            // btnEditarArticulo
            // 
            btnEditarArticulo.Location = new Point(147, 395);
            btnEditarArticulo.Name = "btnEditarArticulo";
            btnEditarArticulo.Size = new Size(75, 23);
            btnEditarArticulo.TabIndex = 2;
            btnEditarArticulo.Text = "Editar";
            btnEditarArticulo.UseVisualStyleBackColor = true;
            // 
            // btnBorrarArticulo
            // 
            btnBorrarArticulo.Location = new Point(240, 395);
            btnBorrarArticulo.Name = "btnBorrarArticulo";
            btnBorrarArticulo.Size = new Size(75, 23);
            btnBorrarArticulo.TabIndex = 3;
            btnBorrarArticulo.Text = "Borrar";
            btnBorrarArticulo.UseVisualStyleBackColor = true;
            btnBorrarArticulo.Click += btnBorrarArticulo_Click;
            // 
            // imageList1
            // 
            imageList1.ColorDepth = ColorDepth.Depth32Bit;
            imageList1.ImageSize = new Size(16, 16);
            imageList1.TransparentColor = Color.Transparent;
            // 
            // listViewArticulos
            // 
            listViewArticulos.FullRowSelect = true;
            listViewArticulos.Location = new Point(427, 42);
            listViewArticulos.Name = "listViewArticulos";
            listViewArticulos.Size = new Size(292, 376);
            listViewArticulos.TabIndex = 4;
            listViewArticulos.UseCompatibleStateImageBehavior = false;
            listViewArticulos.View = View.List;
            listViewArticulos.SelectedIndexChanged += listViewArticulos_SelectedIndexChanged;
            // 
            // pictureBoxArticulo
            // 
            pictureBoxArticulo.Location = new Point(66, 42);
            pictureBoxArticulo.Name = "pictureBoxArticulo";
            pictureBoxArticulo.Size = new Size(249, 185);
            pictureBoxArticulo.TabIndex = 5;
            pictureBoxArticulo.TabStop = false;
            // 
            // panelTituloArticulo
            // 
            panelTituloArticulo.Controls.Add(lblTitulo);
            panelTituloArticulo.Location = new Point(66, 257);
            panelTituloArticulo.Name = "panelTituloArticulo";
            panelTituloArticulo.Size = new Size(249, 59);
            panelTituloArticulo.TabIndex = 6;
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(14, 24);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(34, 15);
            lblTitulo.TabIndex = 0;
            lblTitulo.Text = "TEXT";
            // 
            // AdminArticulos
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(panelTituloArticulo);
            Controls.Add(pictureBoxArticulo);
            Controls.Add(listViewArticulos);
            Controls.Add(btnBorrarArticulo);
            Controls.Add(btnEditarArticulo);
            Controls.Add(btnNuevoArticulo);
            Name = "AdminArticulos";
            Text = "AdminArticulos";
            Load += AdminArticulos_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBoxArticulo).EndInit();
            panelTituloArticulo.ResumeLayout(false);
            panelTituloArticulo.PerformLayout();
            ResumeLayout(false);
        }

        #endregion
        private Button btnNuevoArticulo;
        private Button btnEditarArticulo;
        private Button btnBorrarArticulo;
        private ImageList imageList1;
        private ListView listViewArticulos;
        private PictureBox pictureBoxArticulo;
        private Panel panelTituloArticulo;
        private Label lblTitulo;
    }
}